import java.io.*;
import java.util.*;
public class Main {
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int ans = 0;
    static int[][] map = new int[5][5];

    public static void main(String[] args) throws Exception {
        for(int r=0;r<5;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<5;c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        dfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 3, 0);
        bw.write(ans>1?'1':'0');
        bw.flush();
    }

    static void dfs(int r, int c, int left, int apple){
        int prev = map[r][c];
        if(prev==-1) return;
        apple += prev;
        if(left==0){
            ans = Math.max(ans, apple);
            return;
        }
        map[r][c] = -1;
        for(int d=0;d<4;d++){
            int nr = r+delta[d][0], nc = c+delta[d][1];
            if(!isIn(nr,nc)) continue;
            dfs(nr,nc,left-1,apple);
        }
        map[r][c] = prev;
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < 5 && 0 <= c && c < 5;
    }
}