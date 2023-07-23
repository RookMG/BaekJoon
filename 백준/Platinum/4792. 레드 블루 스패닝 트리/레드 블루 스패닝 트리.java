import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> red = new ArrayList<>(), blue = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        for(int n, m, k, min, max, l;;){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if((n|m|k)==0) break;
            parent = new int[n+1];
            red.clear();
            blue.clear();
            for(int i=0;i<=n;i++){
                red.add(new ArrayList<>());
                blue.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
                if(cmd=='B'){
                    blue.get(a).add(b);
                    blue.get(b).add(a);
                }else{
                    red.get(a).add(b);
                    red.get(b).add(a);
                }
            }
            // min blue
            min = 0;
            l = 0;
            for(int i=1;i<=n;i++) parent[i] = i;
            for(int now=1;now<=n;now++){
                for(int next:red.get(now)){
                    if(findP(now)==findP(next)) continue;
                    parent[findP(now)] = parent[findP(next)];
                    l++;
                }
            }
            span:for(int now=1;now<=n;now++){
                for(int next:blue.get(now)){
                    if(findP(now)==findP(next)) continue;
                    parent[findP(now)] = parent[findP(next)];
                    l++;
                    min++;
                    if(l==n-1) break span;
                }
            }
            // max blue
            max = n-1;
            l = 0;
            for(int i=1;i<=n;i++) parent[i] = i;
            for(int now=1;now<=n;now++){
                for(int next:blue.get(now)){
                    if(findP(now)==findP(next)) continue;
                    parent[findP(now)] = parent[findP(next)];
                    l++;
                }
            }
            span:for(int now=1;now<=n;now++){
                for(int next:red.get(now)){
                    if(findP(now)==findP(next)) continue;
                    parent[findP(now)] = parent[findP(next)];
                    l++;
                    max--;
                    if(l==n-1) break span;
                }
            }
            sb.append((min<=k&&k<=max)?"1\n":"0\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int findP(int num){
        return parent[num] = num==parent[num]?num:findP(parent[num]);
    }
}