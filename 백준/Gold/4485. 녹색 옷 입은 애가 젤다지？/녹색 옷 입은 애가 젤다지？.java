import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int MAX = 156251;
	static final int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] map, dp;
	static int N;
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[2],o2[2]);
		}
	});
	public static void main(String[] args) throws Exception {
		for(int t=1;(N=Integer.parseInt(br.readLine()))!=0;t++){
			map = new int[N][N];
			dp = new int[N][N];
			for(int r=0;r<N;r++){
				st = new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++){
					map[r][c] = Integer.parseInt(st.nextToken());
					dp[r][c] = MAX;
				}
			}
			pq.clear();
			pq.offer(new int[]{0,0,dp[0][0] = map[0][0]});
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + delta[d][0], nc = now[1] + delta[d][1];
					if (!(0<=nr&&nr<N&&0<=nc&&nc<N)) continue;
					int cost = now[2] + map[nr][nc];
					if (dp[nr][nc] > cost) {
						dp[nr][nc] = cost;
						pq.offer(new int[]{nr,nc,cost});
					}
				}
			}
			sb.append("Problem ").append(t).append(": ").append(dp[N-1][N-1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}