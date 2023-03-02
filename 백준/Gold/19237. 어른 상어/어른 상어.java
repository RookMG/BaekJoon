import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static class Cell{
		int smellOf, smellTime, shark;
		Cell(int shark){
			this.shark = shark;
			smellTime = -1*K;
		}
		void setSmell(int num){
			if(!sharks[num].alive) return;
			smellOf = num;
			smellTime = time;
		}
	}
	static class Shark{
		boolean alive;
		int num, dir, r, c;
		int[][] dirPriority = new int[5][4];
		Shark(int num, int r, int c){
			this.num = num;
			this.r = r;
			this.c = c;
			alive = true;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int[][] delta = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M, K, time = 0, alives;
	static Cell[][] map;
	static Shark[] sharks;
	static void getInput() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		map = new Cell[N][N];
		sharks = new Shark[M+1];
		alives = M;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = new Cell(num);
				if(num!=0) sharks[num] = new Shark(num,i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) sharks[i].dir = Integer.parseInt(st.nextToken());
		for(int i=1;i<=M;i++) for(int j=1;j<=4;j++){
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<4;k++) sharks[i].dirPriority[j][k] = Integer.parseInt(st.nextToken());
		}
	}
	public static void main(String[] args) throws Exception {
		getInput();
		while(alives!=1){
			// 냄새 뿌리기
			for(int i=1;i<=M;i++){
				int r = sharks[i].r, c = sharks[i].c;
				map[r][c].setSmell(i);
			}
			time++;
			if(time>1000){
				time = -1;
				break;
			}
			// 방향 지정, 이동
			for(int i=1;i<=M;i++){
				if(!sharks[i].alive) continue;
				int r = sharks[i].r, c = sharks[i].c, dir = sharks[i].dir;
				boolean back = true;
				for(int j=0;j<4;j++){
					int ndir = sharks[i].dirPriority[dir][j], nr = r + delta[ndir][0], nc = c + delta[ndir][1];
					if(isIn(nr,nc)){
						if(map[nr][nc].smellTime<time-K) {
							sharks[i].dir = ndir;
							sharks[i].r = nr;
							sharks[i].c = nc;
							break;
						}else if(back&&map[nr][nc].smellOf==i){
							sharks[i].dir = ndir;
							sharks[i].r = nr;
							sharks[i].c = nc;
							back = false;
						}
					}
				}
				map[r][c].shark = 0;
				if(map[sharks[i].r][sharks[i].c].shark!=0) {
					sharks[i].alive = false;
					alives--;
				}
				else map[sharks[i].r][sharks[i].c].shark = i;
			}
		}
		bw.write(Integer.toString(time));
		bw.flush();
	}
	static boolean isIn(int nr, int nc){
	    return 0<=nr&&nr<N&&0<=nc&&nc<N;
	}
}