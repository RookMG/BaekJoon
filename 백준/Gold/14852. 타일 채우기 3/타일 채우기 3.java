import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[Math.max(3,n+1)][2];
        dp[0][0] = 1;
        dp[1][0] = 2;
        dp[2][0] = 7;
        for(int i=3;i<=n;i++){
            dp[i][0] = (3*dp[i-2][0] + 2*dp[i-1][0] + 2*(dp[i][1] = (dp[i-1][1]+dp[i-3][0])%MOD))%MOD;
        }
        bw.write(Long.toString(dp[n][0]));
        bw.flush();
    }
}