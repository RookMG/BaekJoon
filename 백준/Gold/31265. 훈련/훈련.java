import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), ans = -1;
        br.readLine();
        int[] dp = new int[M+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int cost = Integer.parseInt(st.nextToken());
                for(int j=M-cost;j>=0;j--){
                    if(dp[j]==i-1|dp[j]==i) dp[j+cost] = i;
                }
            }
        }
        for(int i=M;i>=0;i--){
            if(dp[i]!=N) continue;
            ans = i;
            break;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}