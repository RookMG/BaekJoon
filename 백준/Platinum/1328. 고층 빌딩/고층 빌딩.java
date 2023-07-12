import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
        long[][][] dp = new long[N+1][L+1][R+1];
        dp[1][1][1] = 1;
        for(int i=2;i<=N;i++){
            for(int j=1;j<=L;j++){
                for(int k=1;k<=R;k++) dp[i][j][k] = (dp[i-1][j][k]*(i-2)+dp[i-1][j][k-1]+dp[i-1][j-1][k])%MOD;
            }
        }
        bw.write(Long.toString(dp[N][L][R]));
        bw.flush();
    }
}