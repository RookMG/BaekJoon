import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C, answer = 0;
    static boolean[][] visit;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new boolean[R][C];
        map = new char[R][];
        int sr = 0, sc = 0;
        for(int r=0;r<R;r++){
            map[r] = br.readLine().toCharArray();
            for(int c=0;c<C;c++) if(map[r][c]=='I'){
                sr = r;
                sc = c;
            }
        }
        visit[sr][sc] = true;
        dfs(sr,sc);
        bw.write(answer==0?"TT":Integer.toString(answer));
        bw.flush();
    }
    static void dfs(int r, int c){
        if(map[r][c]=='P') answer++;
        for(int d=0;d<4;d++){
            int nr = r + delta[d][0], nc = c + delta[d][1];
            if(!isIn(nr,nc)||visit[nr][nc]) continue;
            visit[nr][nc] = true;
            if(map[nr][nc]!='X') dfs(nr,nc);
        }
    }
    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}