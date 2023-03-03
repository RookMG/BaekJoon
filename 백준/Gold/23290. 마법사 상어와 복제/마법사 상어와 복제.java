import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] diagDelta = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}}, delta = {{-1,0},{0,-1},{1,0},{0,1}};
	static int M, S, sr, sc, eatable;
	static int[] moves = new int[3];
	static int[][] smell = new int[5][5], moveRecord = new int[3][2];
	static int[][][] fish = new int[5][5][9];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), dir = Integer.parseInt(st.nextToken());
			fish[r][c][dir]++;
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()); sc = Integer.parseInt(st.nextToken());
		for(int s = 0;s<S;s++){
			int[][][] duplicate = arrCopy(fish), nfish = new int[5][5][9];
			for(int r=1;r<=4;r++){
				for(int c=1;c<=4;c++){
					nextFish:for(int dir=1;dir<=8;dir++){
						for(int d=0;d<8;d++) {
							int ndir = (dir + 7 - d) % 8 + 1, nr = r + diagDelta[ndir][0], nc = c + diagDelta[ndir][1];
							if (isIn(nr, nc) && (nr != sr || nc != sc) && smell[nr][nc] <= s) {
								nfish[nr][nc][ndir] += fish[r][c][dir];
								continue nextFish;
							}
						}
						nfish[r][c][dir] += fish[r][c][dir];
					}
				}
			}
			fish = nfish;
			eatable = -1;
			recur(0);
			sr = moveRecord[2][0]; sc = moveRecord[2][1];
			for(int j=0;j<3;j++){
				int nr = moveRecord[j][0], nc = moveRecord[j][1];
				for(int d=1;d<=8;d++){
					if(fish[nr][nc][d]!=0) {
						fish[nr][nc][d] = 0;
						smell[nr][nc] = s + 3;
					}
				}
			}
			for(int r=1;r<=4;r++){
				for(int c=1;c<=4;c++){
					for(int dir=1;dir<=8;dir++){
						fish[r][c][dir]+=duplicate[r][c][dir];
					}
				}
			}
		}
		int answer = 0;
		for(int r=1;r<=4;r++){
			for(int c=1;c<=4;c++){
				for(int dir=1;dir<=8;dir++){
					answer += fish[r][c][dir];
				}
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void recur(int move){
		if(move==3){
			int[][][] nfish = arrCopy(fish);
			int tmpr = sr, tmpc = sc, now = 0;
			for(int i=0;i<3;i++){
				tmpr += delta[moves[i]][0];
				tmpc += delta[moves[i]][1];
				if(!isIn(tmpr,tmpc)) return;
				for(int d=1;d<=8;d++) {
					now += nfish[tmpr][tmpc][d];
					nfish[tmpr][tmpc][d] = 0;
				}
			}
			if(now>eatable){
				eatable = now;
				tmpr = sr; tmpc = sc;
				for(int i=0;i<3;i++){
					tmpr += delta[moves[i]][0];
					tmpc += delta[moves[i]][1];
					moveRecord[i][0] = tmpr;
					moveRecord[i][1] = tmpc;
				}
			}
			return;
		}
		for(int i=0;i<4;i++){
			moves[move] = i;
			recur(move+1);
		}
	}
	static int[][][] arrCopy(int[][][] arr){
		int[][][] tmp = new int[arr.length][arr[0].length][];
		for(int i=0;i< arr.length;i++){
			for(int j=0;j< arr[0].length;j++){
				tmp[i][j] = Arrays.copyOf(arr[i][j],arr[i][j].length);
			}
		}
		return tmp;
	}
	static boolean isIn(int nr, int nc){
	    return 0<nr&&nr<=4&&0<nc&&nc<=4;
	}
}