import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
	static final int[][] knight = {{-1,2},{1,2},{2,1},{2,-1},{-1,-2},{1,-2},{-2,1},{-2,-1}};
	static int N, M, K;

	public static void main(String[] args) throws Exception{
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][][] visit = new boolean[N][M][K+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0,0,0});
		int answer = 0, nr=0, nc=0;
		while(!dq.isEmpty()) {
			for(int s = dq.size();s>0;s--) {
				int[] point = dq.pollFirst();
				if(point[0]==N-1&&point[1]==M-1) {
					bw.write(Integer.toString(answer));
					bw.flush();
					return;
				}
				if(point[2]<K) {
					for(int i=0;i<knight.length;i++) {
						nr = point[0]+knight[i][0];
						nc = point[1]+knight[i][1];
						if(isIn(nr,nc)&&!visit[nr][nc][point[2]+1]&&map[nr][nc]==0) {
							visit[nr][nc][point[2]+1]=true;
							dq.offerLast(new int[] {nr,nc,point[2]+1});
						}
					}
				}
				for(int i=0;i<delta.length;i++) {
					nr = point[0]+delta[i][0];
					nc = point[1]+delta[i][1];
					if(isIn(nr,nc)&&!visit[nr][nc][point[2]]&&map[nr][nc]==0) {
						visit[nr][nc][point[2]]=true;
						dq.offerLast(new int[]{nr, nc, point[2]});
					}
				}
			}
			answer++;
		}
		bw.write("-1");
		bw.flush();
	}
	static boolean isIn(int r, int c) {
		return 0<=r&&r<N&&0<=c&&c<M;
	}
}