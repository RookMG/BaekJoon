import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        long[] dp = new long[1_000_001];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<1_000_001;i++) dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%1_000_000_009;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}