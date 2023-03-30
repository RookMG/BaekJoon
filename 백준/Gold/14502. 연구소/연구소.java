import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int R, C, answer, now, size = -3, vsize;
	static int[] virus;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		virus = new int[R*C*2];
		vsize = 0;
		for(int r=0;r<R;r++){
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++){
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==0) size++;
				else if(map[r][c]==2){
					virus[vsize*2] = r;
					virus[vsize++*2+1] = c;
				}
			}
		}
		for(int i=0;i<R*C;i++){
			if(map[i/C][i%C]!=0) continue;
			map[i/C][i%C] = 1;
			for(int j=i+1;j<R*C;j++){
				if(map[j/C][j%C]!=0) continue;
				map[j/C][j%C] = 1;
				for(int k=j+1;k<R*C;k++){
					if(map[k/C][k%C]!=0) continue;
					map[k/C][k%C] = 1;
					visit = new boolean[R][C];
					now = size;
					for(int v=0;v<vsize;v++){
						int r = virus[v*2], c = virus[v*2+1];
						if(visit[r][c]) continue;
						visit[r][c] = true;
						dfs(r,c);
					}
					answer = Math.max(answer,now);
					map[k/C][k%C] = 0;
				}
				map[j/C][j%C] = 0;
			}
			map[i/C][i%C] = 0;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void dfs(int r, int c){
		for(int d = 0;d<4;d++){
			int nr = r+delta[d][0], nc = c+delta[d][1];
			if(!isIn(nr,nc)||visit[nr][nc]) continue;
			visit[nr][nc] = true;
			if(map[nr][nc]==0) {
				now--;
			} else if (map[nr][nc]==1) {
				continue;
			}
			dfs(nr,nc);
		}
	}
	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}