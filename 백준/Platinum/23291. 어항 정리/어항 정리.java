import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, K, sr = 0, sc, er, ec;
	static int[] line;
	static int[][] box;
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		line = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++){
			line[i] = Integer.parseInt(st.nextToken());
		}
		for(int s = 0;;s++){
			int max, min;
			max = min = line[0];
			for(int i=1;i<N;i++){
				max = Math.max(max, line[i]);
				min = Math.min(min, line[i]);
			}
			if(max-min<=K){
				bw.write(Integer.toString(s));
				break;
			}
			for(int i=0;i<N;i++){
				if(line[i]==min) line[i]++;
			}
			sort();
		}
		bw.flush();
	}
	static void sort(){
		roll();
		move();
		fold();
		move();
	}
	static void roll(){
		box = new int[11][N];
		for(int i=0;i<N;i++){
			box[0][i] = line[i];
		}
		sc = 0; er = 1; ec = 1;
		while(er+ec<=N){
			for(int i=0;i<er;i++){
				for(int j=0;j<ec-sc;j++){
					box[ec-sc-j][ec+i] = box[i][sc+j];
				}
			}
			int nsc = ec, ner = 1 + ec - sc, nec = ec + er;
			sc = nsc; er = ner; ec = nec;
		}
		ec = N;
	}
	static void move(){
		int[][] nbox = new int[box.length][box[0].length];
		for(int r = 0;r<er;r++){
			for(int c = sc;c<ec;c++){
				for(int i=0;i<4;i++){
					int nr = r+delta[i][0], nc = c+delta[i][1];
					if(isIn(nr,nc)&&box[r][c]>box[nr][nc]&&box[nr][nc]!=0){
						nbox[nr][nc] += (box[r][c]-box[nr][nc])/5;
						nbox[r][c] -= (box[r][c]-box[nr][nc])/5;
					}
				}
			}
		}
		for(int r = 0;r<er;r++){
			for(int c = sc;c<ec;c++){
				box[r][c] += nbox[r][c];
			}
		}
		int idx = 0;
		for(int c = sc;c<ec;c++){
			for(int r = 0;r<er;r++){
				if(box[r][c]!=0) line[idx++] = box[r][c];
			}
		}
	}
	static void fold(){
		er = 4; sc = 0; ec = N/4;
		box = new int[4][N/4];
		for(int i = 0;i<ec;i++){
			box[0][i] = line[3*ec+i];
		}
		for(int i = 0;i<ec;i++){
			box[1][i] = line[ec-1-i];
		}
		for(int i = 0;i<ec;i++){
			box[2][i] = line[ec+i];
		}
		for(int i = 0;i<ec;i++){
			box[3][i] = line[3*ec-1-i];
		}
	}
	static boolean isIn(int nr, int nc){
	    return sr<=nr&&nr<er&&sc<=nc&&nc<ec;
	}
}