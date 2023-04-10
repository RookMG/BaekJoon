import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int R, C, N, h;
	static char[][] map;
	static boolean[][] visit;
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->Integer.compare(o1[0],o2[0])*-1), nq = new PriorityQueue<int[]>((o1,o2)->Integer.compare(o1[0],o2[0])*-1);
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		for(int r=0;r<R;r++) map[r] = br.readLine().toCharArray();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			int line = Integer.parseInt(st.nextToken());
			for(int c=0,mr=R-line,mc=i%2==0?c:C-1;c<C;c++,mc=i%2==0?c:C-1-c){
				if(map[mr][mc]=='.') continue;
				else {
					map[mr][mc] = '.';
					for (int d = 0, nr, nc; d < 4; d++) {
						visit = new boolean[R][C];
						nr = mr + delta[d][0];
						nc = mc + delta[d][1];
						if (!isIn(nr, nc) || visit[nr][nc] || map[nr][nc] != 'x') continue;
						h = 0;
						visit[nr][nc] = true;
						pq.clear();
						nq.clear();
						dfs(nr, nc);
						if (h == R - 1) continue;
						h = R;
						while (!pq.isEmpty()) {
							int[] now = pq.poll();
							nq.add(now);
							map[now[0]][now[1]] = '.';
							h = Math.min(h, R - now[0] - 1);
							for (int k = now[0] + 1; k < R; k++) {
								if (map[k][now[1]] == 'x') {
									h = Math.min(h, k - now[0] - 1);
									break;
								}
							}
						}
						while (!nq.isEmpty()) {
							int[] now = nq.poll();
							map[now[0] + h][now[1]] = 'x';
						}
					}
					break;
				}
			}
		}
		for(int r=0;r<R-1;r++){
			for(int c=0;c<C;c++) bw.write(map[r][c]);
			bw.write('\n');
		}
		for(int c=0;c<C;c++) bw.write(map[R-1][c]);
		bw.flush();
	}
	static void dfs(int r,int c){
		pq.add(new int[]{r,c});
		h = Math.max(h,r);
		for(int d=0,nr,nc;d<4;d++){
			nr = r+delta[d][0];
			nc = c+delta[d][1];
			if(!isIn(nr,nc)||visit[nr][nc]) continue;
			visit[nr][nc]=true;
			if(map[nr][nc]!='.') dfs(nr,nc);
		}
	}
	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}