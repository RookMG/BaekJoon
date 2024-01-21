import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static int[][] arr, dp;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        arr = new int[R=Integer.parseInt(st.nextToken())][C=Integer.parseInt(st.nextToken())];
        dp = new int[R][C];
        visit = new boolean[R][C];
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++) arr[r][c] = Integer.parseInt(st.nextToken());
        }
        bw.write(Integer.toString(dfs(R-1,C-1)));
        bw.flush();
    }
    static int dfs(int r, int c){
        if(r==0&&c==0) return 1;
        if(visit[r][c]) return dp[r][c];
        for(int d=0;d<4;d++){
            int nr = r+delta[d][0], nc = c+delta[d][1];
            if(!isIn(nr,nc)||arr[r][c]>=arr[nr][nc]) continue;
            dp[r][c] += dfs(nr,nc);
        }
        visit[r][c] = true;
        return dp[r][c];
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}