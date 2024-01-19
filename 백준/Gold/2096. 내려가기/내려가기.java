import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][6];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) dp[i%2][j] = dp[i%2][j+3] = Integer.parseInt(st.nextToken());
            dp[i%2][0] += Math.min(dp[(i+1)%2][0],dp[(i+1)%2][1]);
            dp[i%2][1] += Math.min(Math.min(dp[(i+1)%2][0],dp[(i+1)%2][1]),dp[(i+1)%2][2]);
            dp[i%2][2] += Math.min(dp[(i+1)%2][1],dp[(i+1)%2][2]);
            dp[i%2][3] += Math.max(dp[(i+1)%2][3],dp[(i+1)%2][4]);
            dp[i%2][4] += Math.max(Math.max(dp[(i+1)%2][3],dp[(i+1)%2][4]),dp[(i+1)%2][5]);
            dp[i%2][5] += Math.max(dp[(i+1)%2][4],dp[(i+1)%2][5]);
        }
        sb.append(Math.max(Math.max(dp[(N+1)%2][3],dp[(N+1)%2][4]),dp[(N+1)%2][5])).append(' ').append(Math.min(Math.min(dp[(N+1)%2][0],dp[(N+1)%2][1]),dp[(N+1)%2][2]));
        bw.write(sb.toString());
        bw.flush();
    }
}