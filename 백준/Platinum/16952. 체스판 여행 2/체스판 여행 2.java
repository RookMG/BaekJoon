import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, answer, changes;
	static int[][] map;
	static int[][][] moves; // bishop, rook, knight
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		answer = 3*N*N;
		map = new int[N][N];
		makeMoves();
		Queue<int[]> q = new LinkedList<>();
		int[][][][] visit = new int[3][N][N][N*N+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if((map[i][j]=Integer.parseInt(st.nextToken()))==1){
					q.offer(new int[] {i,j,1,0,0,0});
					q.offer(new int[] {i,j,1,1,0,0});
					q.offer(new int[] {i,j,1,2,0,0});
					visit[0][i][j][1]=0;
					visit[1][i][j][1]=0;
					visit[2][i][j][1]=0;
				}
				for(int k=0;k<3;k++) {
					Arrays.fill(visit[k][i][j], answer);
				}
			}
		}
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0], c = now[1], found = now[2], piece = now[3], time = now[4], change = now[5];
			if(map[r][c]==found+1){found++;}
			if(found==N*N) {
				if(answer>time) {
					answer = time;
					changes = change;
				}else if(answer == time) {
					changes = Math.min(changes,change);
				}
			}
			for(int i=0;i<moves[piece].length;i++){
				int nr = r + moves[piece][i][0], nc = c + moves[piece][i][1];
				if(isIn(nr,nc)&&visit[piece][nr][nc][found]>change){
					visit[piece][nr][nc][found] = change;
					q.add(new int[]{nr,nc,found,piece,time+1,change});
				}
			}
			for(int i=1;i<=2;i++) {
				if(visit[(piece+i)%3][r][c][found]>change){
					visit[(piece+i)%3][r][c][found] = change+1;
					q.add(new int[]{r,c,found,(piece+i)%3,time+1,change+1});
				}
			}
		}
		System.out.printf("%d %d",answer,changes);
	}
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	static void makeMoves() {
		moves = new int[3][][];
		moves[0] = new int[4*N-4][2]; moves[1] = new int[4*N-4][2];
		for(int i=1;i<N;i++) {
			moves[0][0*(N-1)+i-1][0] =  i; moves[0][0*(N-1)+i-1][1] =  i;
			moves[0][1*(N-1)+i-1][0] =  i; moves[0][1*(N-1)+i-1][1] = -i;
			moves[0][2*(N-1)+i-1][0] = -i; moves[0][2*(N-1)+i-1][1] =  i;
			moves[0][3*(N-1)+i-1][0] = -i; moves[0][3*(N-1)+i-1][1] = -i;
			moves[1][0*(N-1)+i-1][0] =  i; moves[1][0*(N-1)+i-1][1] =  0;
			moves[1][1*(N-1)+i-1][0] = -i; moves[1][1*(N-1)+i-1][1] =  0;
			moves[1][2*(N-1)+i-1][0] =  0; moves[1][2*(N-1)+i-1][1] =  i;
			moves[1][3*(N-1)+i-1][0] =  0; moves[1][3*(N-1)+i-1][1] = -i;
		}
		moves[2] = new int[][]{ { -1, 2 }, { 1, 2 }, { 2, -1 }, { 2, 1 }, { -1, -2 }, { 1, -2 }, { -2, -1 }, { -2, 1 } };
	}
}