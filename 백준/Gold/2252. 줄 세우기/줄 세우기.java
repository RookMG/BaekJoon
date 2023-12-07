import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] outs = new ArrayList[n+1];
        for(int i=1;i<n+1;i++) outs[i] = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] ins = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            ins[b]++;
            outs[a].add(b);
        }
        for(int i=1;i<=n;){
            for(int j=1;j<=n;j++){
                if(ins[j]!=0) continue;
                sb.append(j).append(" ");
                q.add(j);
                ins[j]--;
                i++;
            }
            while(!q.isEmpty()){
                int num = q.poll();
                while(!outs[num].isEmpty()) ins[outs[num].remove(0)]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}