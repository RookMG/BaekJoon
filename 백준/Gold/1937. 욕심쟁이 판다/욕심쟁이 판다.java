import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map, dp;
    static int N, ans = 0;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        for(int r=0;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++) map[r][c] = Integer.parseInt(st.nextToken());
        }
        for(int r=0;r<N;r++) for(int c=0;c<N;c++) ans = Math.max(ans,dfs(r,c));
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static int dfs(int r, int c){
        if(dp[r][c]!=0) return dp[r][c];
        dp[r][c] = 1;
        for(int d=0;d<4;d++){
            int nr = r+delta[d][0], nc = c+delta[d][1];
            if(!isIn(nr,nc)||map[r][c]>=map[nr][nc]) continue;
            dp[r][c] = Math.max(dp[r][c],dfs(nr,nc)+1);
        }
        return dp[r][c];
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}