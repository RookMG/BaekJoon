import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}, rotateInfo = {{},{3,0,1,4},{1,0,3,4},{5,0,2,4},{2,0,5,4}};
	static int R, C, r, c, K;
	static int[][] map;
	static int[] dice = {0,0,0,0,0,0};
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0;i<R;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++){
			move(Integer.parseInt(st.nextToken()));
		}
		bw.flush();
	}
	static void move(int dir) throws Exception {
		int nr = r+delta[dir][0], nc = c+delta[dir][1];
		if(!isIn(nr,nc)) return;
		int tmp = dice[rotateInfo[dir][0]];
		for(int i=1;i<4;i++){
			dice[rotateInfo[dir][i-1]] = dice[rotateInfo[dir][i]];
		}
		if(map[nr][nc]!=0){
			dice[4] = map[nr][nc];
			map[nr][nc] = 0;
		}else{
			dice[4] = map[nr][nc] = tmp;
		}
		r = nr;
		c = nc;
		bw.write(Integer.toString(dice[0]));
		bw.write("\n");
	}
	static boolean isIn(int nr, int nc){
	    return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}
}