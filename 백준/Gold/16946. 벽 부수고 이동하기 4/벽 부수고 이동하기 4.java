import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, adj;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int[][][] result;
	static boolean[][] visit;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int idx = 1;
		map = new int[R][C];
		result = new int[R][C][2];
		visit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			int c = 0;
			for (char ch : br.readLine().toCharArray()) {
				map[r][c++] = ch - '0';
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0 && !visit[r][c]) {
					visit[r][c] = true;
					adj = 1;
					q = new ArrayDeque<int[]>();
					q.add(new int[] {r,c});
					dfs(r,c);
					adj%=10;
					while(!q.isEmpty()) {
						result[q.peek()[0]][q.peek()[1]][1] = idx;
						result[q.peek()[0]][q.poll()[1]][0] = adj;
					}
					idx++;
				}
			}
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c]==0) {sb.append(0);}
				else {
					int ans = 1;
					int[] same = new int[4];
					for(int i=0;i<4;i++) {
						int nr = r+delta[i][0], nc = c+delta[i][1];
						if(isIn(nr,nc)) {
							boolean dup = false;
							for(int j = 0;j<i;j++) {
								if(result[nr][nc][1]==same[j])
									dup = true;
							}
							if(!dup)
								ans+=result[nr][nc][0];
							same[i] = result[nr][nc][1];
						}
					}
					sb.append(ans%10);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static void dfs(int r, int c) {
		for(int i=0;i<4;i++) {
			int nr = r+delta[i][0], nc = c+delta[i][1];
			if(isIn(nr,nc)&&!visit[nr][nc]&&map[nr][nc]==0) {
				q.add(new int[] {nr,nc});
				adj++;
				visit[nr][nc] = true;
				dfs(nr,nc);
			}
		}
	}
	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}