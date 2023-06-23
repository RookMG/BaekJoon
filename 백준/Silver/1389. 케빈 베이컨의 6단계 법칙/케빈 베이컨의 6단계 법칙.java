import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],INF);
            graph[i][i] = 0;
        }
        for(int i=0;i<v;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            graph[s][e] = graph[e][s] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int start=1;start<=n;start++){
                for(int end=1;end<=n;end++){
                    graph[start][end] = Math.min(graph[start][end],graph[start][i]+graph[i][end]);
                }
            }
        }
        int ans = 0, sums = INF;
        for(int i=1, sum;i<=n;i++){
            sum = 0;
            for(int j=1;j<=n;j++){
                sum+=graph[i][j];
            }
            if(sum<sums){
                ans = i;
                sums = sum;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}