import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static int[] ans;
	static char[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N]; visit = new boolean[N][N][2]; ans = new int[2];
		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
		for(int i=0;i<N;i++) for (int j = 0; j < N; j++) for (int k = 0; k < 2; k++) {
			if (visit[i][j][k]) continue;
			visit[i][j][k] = true;
			ans[k]++;
			dfs(i, j, k);
		}
		bw.write(Integer.toString(ans[0]));
		bw.write(" ");
		bw.write(Integer.toString(ans[1]));
		bw.flush();
	}
	static void dfs(int r, int c, int type){
		for(int i=0;i<4;i++){
			int nr = r+delta[i][0], nc = c+delta[i][1];
			if(isIn(nr,nc)&&!visit[nr][nc][type]&&(map[r][c]==map[nr][nc]||(type==1&&map[r][c]+map[nr][nc]=='R'+'G'))){
				visit[nr][nc][type] = true;
				dfs(nr,nc,type);
			}
		}
	}
	static boolean isIn(int nr, int nc){
		return 0<=nr&&nr<N&&0<=nc&&nc<N;
	}
}