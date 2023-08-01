import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] sum = new int[N+1];
            int[][] dp = new int[N+1][N+1], K = new int[N+1][N+1];
            for(int i=1;i<=N;i++) sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++) K[i][i+1] = i;
            for(int i=2;i<=N;i++){
                for(int j=0;j<=N-i;j++){
                    dp[j][i+j] = Integer.MAX_VALUE/3;
                    for(int k=K[j][i+j-1];k<K[j+1][j+i]+1;k++){
                        int now = dp[j][k]+dp[k][i+j]+sum[i+j]-sum[j];
                        if(dp[j][i+j]<=now) continue;;
                        dp[j][i+j] = now;
                        K[j][i+j] = k;
                    }
                }
            }
            sb.append(dp[0][N]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}