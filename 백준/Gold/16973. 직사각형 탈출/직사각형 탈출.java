import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int n, m, h, w;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				if(1==(map[i][j] = Integer.parseInt(st.nextToken())))
					q.offer(new int[] {i,j});
			}
		}
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int r=Math.max(0,now[0]-h+1);r<=now[0];r++) {
				for(int c=Math.max(0,now[1]-w+1);c<=now[1];c++) {
					map[r][c] = 1;
				}
			}
		}
		q = new ArrayDeque<>();
		int sr = Integer.parseInt(st.nextToken())-1, sc = Integer.parseInt(st.nextToken())-1, fr = Integer.parseInt(st.nextToken())-1, fc = Integer.parseInt(st.nextToken())-1;
		q.offerLast(new int[] {sr,sc,0});
		visit[sr][sc] = true;
		map[fr][fc]=2;
		if(sr==fr&&sc==fc) {
			bw.write("0");
			bw.flush();
			return;
		}
		while(!q.isEmpty()) {
			int[] now = q.pollFirst();
			for(int i=0;i<4;i++) {
				int nr = now[0]+delta[i][0], nc = now[1]+delta[i][1], time = now[2]+1;
				if(!isIn(nr,nc)) continue;
				if(map[nr][nc]==2) {
					bw.write(Integer.toString(time));
					bw.flush();
					return;
				}
				if(!visit[nr][nc]) {
					visit[nr][nc] = true;
					if(map[nr][nc]==0)
						q.offerLast(new int[] {nr,nc,time});
				}
			}
		}
		bw.write("-1");
		bw.flush();
	}
	static boolean isIn(int r, int c) {
		return 0 <= r && r <= n-h && 0 <= c && c <= m-w;
	}
}