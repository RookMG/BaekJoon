import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static boolean[][] map, visit;
    static int[][] ans;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        visit = new boolean[R][C];
        ans = new int[R][C];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int sr = 0, sc = 0;
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++){
                char ch = st.nextToken().charAt(0);
                map[r][c] = ch=='1';
                if(ch=='2'){
                    visit[r][c] = true;
                    dq.add(new int[]{r,c});
                }else if(ch=='1') ans[r][c] = -1;
            }
        }
        for(int l=1;!dq.isEmpty();l++){
            for(int s=dq.size();s>0;s--){
                int[] now = dq.pollFirst();
                for(int d=0;d<4;d++){
                    int nr = now[0]+delta[d][0], nc = now[1]+delta[d][1];
                    if(!isIn(nr,nc)||visit[nr][nc]||!map[nr][nc]) continue;
                    ans[nr][nc] = l;
                    visit[nr][nc] = true;
                    dq.offerLast(new int[]{nr,nc});
                }
            }
        }
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++) sb.append(ans[r][c]).append(' ');
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}