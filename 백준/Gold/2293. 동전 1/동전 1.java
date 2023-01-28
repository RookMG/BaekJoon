import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()), target = Integer.parseInt(st.nextToken());
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int t=0;t<T;t++){
            int val = Integer.parseInt(br.readLine());
            for(int i = val;i<=target;i++){
                dp[i]+=dp[i-val];
            }
        }
        System.out.println(dp[target]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}