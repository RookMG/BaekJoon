import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}, wind = {{1, 2, 1}, {1, 7}, {1, 1, 2}, {0, 1, 10}, {0, 0, 5}, {3, 2, 1}, {3, 7}, {3, 3, 2}, {0, 3, 10}};
	static int N, r, c, dir, l;
	static long answer = 0;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		r = N / 2;
		c = N / 2;
		dir = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (l = 1; l < N; dir = (dir+1)%4) {
			for(int i=0;i<l;i++){
				r+=delta[dir][0];
				c+=delta[dir][1];
				move();
			}
			if((dir&1)==1) l++;
		}
		l--;
		for(int i=0;i<l;i++){
			r+=delta[dir][0];
			c+=delta[dir][1];
			move();
		}
		bw.write(Long.toString(answer));
		bw.flush();
	}

	static void move(){
		int moved = 0, sand = map[r][c];
		map[r][c] = 0;
		for(int[] cell: wind){
			int nr = r, nc = c, move = sand*cell[cell.length-1]/100;
			for(int i=0;i<cell.length-1;i++){
				nr += delta[(dir+cell[i])%4][0];
				nc += delta[(dir+cell[i])%4][1];
			}
			moved += move;
			if(isIn(nr,nc)) map[nr][nc]+=move;
			else answer += move;
		}
		if(isIn(r+delta[dir][0],c+delta[dir][1])) map[r+delta[dir][0]][c+delta[dir][1]]+=sand-moved;
		else answer += sand-moved;
	}

	static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}
}