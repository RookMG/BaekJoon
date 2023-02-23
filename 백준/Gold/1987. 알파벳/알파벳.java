import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, answer = 0;
	static char[][] map;
	static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static long[] check = new long[26];
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		long l = 1L;
		for(int i=0;i<26;i++,l<<=1)check[i] = l;
		for(int i=0;i<R;i++) map[i] = br.readLine().toCharArray();
		recur(0,0,1,1L<<(map[0][0]-'A'));
		System.out.print(answer);
	}
	static void recur(int r, int c, int l, long visit){
		for(int i=0;i<4;i++){
			int nr = r + delta[i][0], nc = c + delta[i][1];
			if(isIn(nr,nc)){
				long check = 1L<<(map[nr][nc]-'A');
				if((visit&check)!=0L) answer = Math.max(answer,l);
				else{
					recur(nr,nc,l+1,visit|check);
				}
			}
		}
	}
	static boolean isIn(int nr, int nc){
		return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}
}