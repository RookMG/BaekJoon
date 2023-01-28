import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(3,n+1)];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2]*2 + dp[i-1])%10007;
        }
        System.out.println(dp[n]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}