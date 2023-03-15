import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, K, cnt, answer;
	static int[] parent;
	static int[][] map;
	static boolean[][] visit;
	static Deque<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		answer = 0;
		map = new int[N][N];
		visit = new boolean[N][N];
		parent = new int[K+1];
		for(int i=1;i<=K;i++) parent[i] = i;
		for(int i=1;i<=K;i++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = i;
			for(int d=0;d<4;d++){
				int nr = r+delta[d][0], nc = c+delta[d][1];
				if(isIn(nr,nc)&&map[nr][nc]!=0){
					int ap = findP(map[r][c]), bp = findP(map[nr][nc]);
					if(ap!=bp){
						parent[Math.max(ap,bp)] = Math.min(ap,bp);
						cnt++;
					}
				}
			}
			q.offer(new int[]{r,c, map[r][c]});
			visit[r][c] = true;
		}
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				System.out.print(parent[map[i][j]]);
//			}
//			System.out.println();
//		}
		while(cnt<K-1){
			for(int size = q.size();size>0;size--){
				int[] now = q.pollFirst();
				for(int d=0;d<4;d++) {
					int nr = now[0] + delta[d][0], nc = now[1] + delta[d][1];
					if(isIn(nr,nc)){
						if(map[nr][nc]!=0) {
							int ap = findP(now[2]), bp = findP(map[nr][nc]);
							if (ap != bp) {
								parent[Math.max(ap, bp)] = Math.min(ap, bp);
								cnt++;
							}
						}else{
							map[nr][nc] = now[2];
							if(isIn(nr + delta[d][0],nc + delta[d][1])&&map[nr + delta[d][0]][nc + delta[d][1]]!=0) {
								int ap = findP(now[2]), bp = findP(map[nr + delta[d][0]][nc + delta[d][1]]);
								if (ap != bp) {
									parent[Math.max(ap, bp)] = Math.min(ap, bp);
									cnt++;
								}
							}
						}
						if(!visit[nr][nc]) {
							visit[nr][nc] = true;
							q.offerLast(new int[]{nr, nc, now[2]});
						}
					}
				}
			}
			answer++;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static int findP(int a){
		return parent[a] = parent[a]==a?a:findP(parent[a]);
	}
	static boolean isIn(int nr, int nc){
	    return 0<=nr&&nr<N&&0<=nc&&nc<N;
	}
}