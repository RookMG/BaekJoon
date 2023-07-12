import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = 1_000_000_000L;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 1;
        for(int b=1;b<=N;b<<=1) for(int i=b;i<=N;i++) dp[i] = (dp[i]+dp[i-b])%MOD;
        bw.write(Long.toString(dp[N]));
        bw.flush();
    }
}