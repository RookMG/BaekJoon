import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++) map[r][c] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(map[r][c]==0) continue;
                if(isIn(r+map[r][c],c)) dp[r+map[r][c]][c] += dp[r][c];
                if(isIn(r,c+map[r][c])) dp[r][c+map[r][c]] += dp[r][c];
            }
        }
        bw.write(Long.toString(dp[N-1][N-1]));
        bw.flush();
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}