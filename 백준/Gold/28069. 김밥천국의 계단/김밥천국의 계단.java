import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        Arrays.fill(dp,1000001);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=1;i<N;i++){
            dp[i+1] = Math.min(dp[i+1],dp[i]+1);
            if(i+(i>>1)>N) continue;
            dp[i+(i>>1)] = Math.min(dp[i+(i>>1)],dp[i]+1);
        }
        bw.write(dp[N]>K?"water":"minigimbob");
        bw.flush();
    }
}