// https://arxiv.org/pdf/1905.02387.pdf
// https://nicotina04.tistory.com/215
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final long MOD = 1_000_000_007;
    static long[] dp = new long[10_000_001];
    public static void main(String[] args) throws Exception {
        dp[0]=dp[1]=1;
        dp[4]=2;
        for(int i=5;i<=10_000_000;i++) dp[i] = ((i+1)*dp[i-1]%MOD-(i-2)*dp[i-2]%MOD-(i-5)*dp[i-3]%MOD+(i-3)*dp[i-4]%MOD+4*MOD)%MOD;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}