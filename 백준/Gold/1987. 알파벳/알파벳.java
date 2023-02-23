import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C, answer = 0;
	static char[][] map;
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] visit;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		map = new char[R][C]; visit = new int[R][C];
		for(int i=0;i<R;i++) map[i] = br.readLine().toCharArray();
		visit[0][0] = 1<<(map[0][0]-'A');
		recur(0,0,1,1<<(map[0][0]-'A'));
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void recur(int r, int c, int l, int bits){
		for(int i=0;i<4;i++){
			int nr = r + delta[i][0], nc = c + delta[i][1];
			if(isIn(nr,nc)){
				int check = 1<<(map[nr][nc]-'A'), next = bits|check;
				if((bits&check)!=0) answer = Math.max(answer,l);
				else if(visit[nr][nc]!=next){
					visit[nr][nc] = next;
					recur(nr,nc,l+1,next);
				}
			}
		}
	}
	static boolean isIn(int nr, int nc){
		return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}
}