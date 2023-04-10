import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int R, C, T;
	static char[][] map, ans;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new char[R][];
		ans = new char[R][C];
		for(int r=0;r<R;r++) map[r] = br.readLine().toCharArray();
		for(int r=0;r<R;r++) Arrays.fill(ans[r],'O');
		if(T==1) for(int r=0;r<R;r++) ans[r]=map[r];
		if(T%2!=0&&T!=1){
			T/=2;
			for(int r=0;r<R;r++){
				for(int c=0;c<C;c++){
					if(map[r][c]!='O') continue;
					ans[r][c] = '.';
					for(int d=0;d<4;d++){
						int nr = r+delta[d][0], nc = c+delta[d][1];
						if(!isIn(nr,nc)) continue;
						ans[nr][nc] = '.';
					}
				}
			}
			if(T%2==0){
				for(int r=0;r<R;r++){
					map[r] = Arrays.copyOf(ans[r],C);
					Arrays.fill(ans[r],'O');
				}
				for(int r=0;r<R;r++){
					for(int c=0;c<C;c++){
						if(map[r][c]!='O') continue;
						ans[r][c] = '.';
						for(int d=0;d<4;d++){
							int nr = r+delta[d][0], nc = c+delta[d][1];
							if(!isIn(nr,nc)) continue;
							ans[nr][nc] = '.';
						}
					}
				}
			}
		}
		for(int r=0;r<R;r++){
			for(int c=0;c<C;c++){
				sb.append(ans[r][c]);
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}