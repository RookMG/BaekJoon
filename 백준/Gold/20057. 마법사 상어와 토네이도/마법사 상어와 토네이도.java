import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 준홍 코드

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[][] board;
	static int answer = 0;
	static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static boolean isIn(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}
	static int[][][] moveDir =
			{
					{
							{0,-2, 5},{-1,-1,10},{1,-1,10},{-2,0,2},{-1,0,7},{1,0,7},{2,0,2},{-1,1,1},{1,1,1},{0,-1}
					},{
					{2,0,5},{1,-1,10},{1,1,10},{0,-2,2},{0,-1,7},{0,1,7},{0,2,2},{-1,-1,1},{-1,1,1},{1,0}
			},{
					{0,2,5},{1,1,10},{-1,1,10},{2,0,2},{1,0,7},{-1,0,7},{-2,0,2},{1,-1,1},{-1,-1,1},{0,1}
			},{
					{-2,0,5},{-1,1,10},{-1,-1,10},{0,2,2},{0,1,7},{0,-1,7},{0,-2,2},{1,1,1},{1,-1,1},{-1,0}
			}
			};

	static void moveTo(int r, int c, int d) {
		int target = board[r][c];
		int[][] movement = moveDir[d];
		int remain = target;
		int nr;
		int nc;
		int sand;
		for(int i=0;i<9;i++) {
			nr = r+movement[i][0];
			nc = c+movement[i][1];
			sand = target*movement[i][2]/100;
			if(isIn(nr,nc)) {
				board[nr][nc] += sand;
			}else {
				answer +=sand;
			}
			remain -=sand;
		}
		nr = r+movement[9][0];
		nc = c+movement[9][1];
		if(isIn(nr,nc)) {
			board[nr][nc] += remain;
		}else {
			answer +=remain;
		}
		board[r][c] = 0;
	}
	static void play(int i, int j) {
		int r = i;
		int c = j;
		int d = 0;
		int offset = 1;
		int nowGo = 0;
		int lengthBreak = 0;
		while(true) {
			r = r+dir[d][0];
			c = c+dir[d][1];
			nowGo++;
			moveTo(r,c,d);
			if(r==0 && c==0){
				System.out.println(answer);
				return;
			}

			if(nowGo == offset) {
				lengthBreak++;
				d = (d+1)%4;
				nowGo=0;
				if(lengthBreak ==2) {
					offset++;
					lengthBreak = 0;
				}
			}

		}
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play((N-1)/2, (N-1)/2);
	}
}