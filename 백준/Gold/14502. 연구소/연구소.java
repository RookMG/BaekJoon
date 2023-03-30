import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int R, C, answer = 0, now;
	static ArrayList<int[]> holes = new ArrayList<>(), virus = new ArrayList<>();
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int r=0;r<R;r++){
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++){
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==0) holes.add(new int[]{r,c});
				else if(map[r][c]==2) virus.add(new int[]{r,c});
			}
		}
		recur(0, 0);
		bw.write(Integer.toString(answer));
		bw.flush();
	}

	static void recur(int order, int start){
		if(order==3){
			visit = new boolean[R][C];
			now = holes.size()-3;
			for(int[] pos:virus){
				if(visit[pos[0]][pos[1]]) continue;
				visit[pos[0]][pos[1]] = true;
				dfs(pos[0],pos[1]);
			}
			answer = Math.max(answer,now);
			return;
		}
		for(int i=start;i<holes.size();i++){
			map[holes.get(i)[0]][holes.get(i)[1]] = 1;
			recur(order+1,i+1);
			map[holes.get(i)[0]][holes.get(i)[1]] = 0;
		}
	}

	static void dfs(int r, int c){
		for(int d = 0;d<4;d++){
			int nr = r+delta[d][0], nc = c+delta[d][1];
			if(!isIn(nr,nc)||visit[nr][nc]||map[nr][nc]==1) continue;
			visit[nr][nc] = true;
			if(map[nr][nc]==0) now--;
			dfs(nr,nc);
		}
	}

	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}