import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), max = -1000000;
        int[][] actions = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            actions[i][0] = Integer.parseInt(st.nextToken());
            actions[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[K+1][5500];
        for(int i=0;i<=K;i++) Arrays.fill(dp[i],-1);
        dp[0][1] = 0;
        for(int t=0;t<K;t++){
            for(int i=0;i<5050;i++){
                if(dp[t][i] == -1) continue;
                max = Math.max(max,dp[t+1][i] = Math.max(dp[t][i] + i, dp[t+1][i]));
                for(int[] action:actions){
                    dp[t+1][i+action[1]] = Math.max(dp[t+1][i+action[1]],dp[t][i]-action[0]);
                }
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
    }
}