import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] cost = new int[N+1][M+1];
        int[][][] dp = new int[N+1][M+1][3];
        int[] invest = new int[M];
        for(int n=1;n<=N;n++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int m = 1; m <= M; m++) cost[n][m] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=M;i++){
            for(int j=0;j<=N;j++){
                for(int k=0;k<=j;k++){
                    if(dp[j][i][0]>=dp[j-k][i-1][0]+cost[k][i]) continue;
                    dp[j][i][0] = dp[j-k][i-1][0] + cost[k][i];
                    dp[j][i][1] = j-k;
                    dp[j][i][2] = i-1;
                }
            }
        }
        sb.append(dp[N][M][0]).append('\n');
        for(int n=N,m=M, nn, nm, cnt = m-1;n>0&&m>0;n=nn,m=nm){
            invest[cnt--] = n-dp[n][m][1];
            nn = dp[n][m][1];
            nm = dp[n][m][2];
        }
        for(int m=0;m<M;m++) sb.append(invest[m]).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
}