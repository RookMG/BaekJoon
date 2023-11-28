import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R, C, ans;
    static int[] cost, next, parent;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R  = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cost = new int[R*C];
        next = new int[R*C];
        parent = new int[R*C];
        boolean[] visit = new boolean[R*C];
        for(int r=0;r<R;r++){
            String s = br.readLine();
            for(int c=0;c<C;c++){
                switch (s.charAt(c)){
                    case 'L':
                        next[r*C+c] = c>0?r*C+c-1:-1;
                        break;
                    case 'R':
                        next[r*C+c] = c<C-1?r*C+c+1:-1;
                        break;
                    case 'U':
                        next[r*C+c] = r>0?(r-1)*C+c:-1;
                        break;
                    case 'D':
                        next[r*C+c] = r<R-1?(r+1)*C+c:-1;
                        break;
                }
                parent[r*C+c] = r*C+c;
            }
        }
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++) cost[r*C+c] = Integer.parseInt(st.nextToken());
        }
        for(int i=R*C-1;i>=0;i--){
            for(int now = i;!visit[now];now = next[now]){
                visit[now] = true;
                if(next[now]==-1) break;
                int ap = findP(now), bp = findP(next[now]);
                if(ap==bp){
                    int min = cost[now];
                    for(int s = next[now];s!=now;s=next[s]) min = Math.min(min,cost[s]);
                    ans += min;
                    break;
                }
                parent[Math.max(ap,bp)] = Math.min(ap,bp);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static int findP(int num){
        return parent[num] = num==parent[num]?num:findP(parent[num]);
    }
}