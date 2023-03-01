import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, Q, length, sum = 0, max = 0, now;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        length = 1 << N;
        map = new int[length][length];
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) sum += map[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            rotate(Integer.parseInt(st.nextToken()));
            melt();
        }

        visit = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!visit[i][j] && map[i][j] != 0) {
                    visit[i][j] = true;
                    now = 0;
                    dfs(i, j);
                    max = Math.max(max, now);
                }
            }
        }
        bw.write(Integer.toString(sum));
        bw.write("\n");
        bw.write(Integer.toString(max));
        bw.flush();
    }

    static void rotate(int L) {
        if(L==0) return;
        int step = 1 << L;
        int[][] nmap = new int[length][length];
        for (int sr = 0; sr < length; sr += step) {
            for (int sc = 0; sc < length; sc += step) {
                for (int i = 0; i < step; i++) {
                    for (int j = 0; j < step; j++) {
                        nmap[sr + i][sc + j] = map[sr + step - 1 - j][sc + i];
                    }
                }
            }
        }
        map = nmap;
    }

    static void melt() {
        int[][] nmap = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((nmap[i][j] = map[i][j]) == 0) continue;
                int adj = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + delta[d][0], nc = j + delta[d][1];
                    if (isIn(nr, nc) && map[nr][nc] != 0) adj++;
                }
                if (adj < 3) {
                    nmap[i][j]--;
                    sum--;
                }
            }
        }
        map = nmap;
    }

    static void dfs(int r, int c) {
        now++;
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0], nc = c + delta[i][1];
            if (isIn(nr, nc) && !visit[nr][nc]) {
                visit[nr][nc] = true;
                if (map[nr][nc] != 0) dfs(nr, nc);
            }
        }
    }

    static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < length && 0 <= nc && nc < length;
    }
}