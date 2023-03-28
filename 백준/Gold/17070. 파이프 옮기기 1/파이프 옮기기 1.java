import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1][3];
        for(int r=1;r<=N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1;c<=N;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                if(map[r][c]!=0) continue;
                dp[r][c][0] += dp[r][c-1][0]+dp[r][c-1][1];
                dp[r][c][2] += dp[r-1][c][2]+dp[r-1][c][1];
                if(map[r-1][c]!=0||map[r][c-1]!=0) continue;
                dp[r][c][1] += dp[r-1][c-1][0]+dp[r-1][c-1][1]+dp[r-1][c-1][2];
            }
        }
        int answer = dp[N][N][0]+dp[N][N][1]+dp[N][N][2];
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}