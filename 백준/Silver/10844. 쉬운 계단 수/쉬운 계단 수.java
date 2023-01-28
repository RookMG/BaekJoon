import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long [n][10];
        for(int i=1;i<=9;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<9;j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
            }
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
        }
        long answer = 0;
        for(int i=0;i<10;i++){
            answer=(answer + dp[n-1][i])%1000000000;
        }
        System.out.println(answer%1000000000);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}