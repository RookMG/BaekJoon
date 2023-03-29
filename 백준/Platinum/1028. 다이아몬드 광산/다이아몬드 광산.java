import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R, C, answer;
	static char[][] map;
	static int[][][] dp; // ↙↘
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); answer = 0;
		map = new char[R][];
		for(int r=0;r<R;r++){
			map[r] = br.readLine().toCharArray();
		}
		dp = new int[R][C][2];
		for(int r=0;r<R;r++){
			for(int c=0;c<C;c++){
				if(map[r][c]=='0') continue;
				dp[r][c][0] = isIn(r-1,c+1)?dp[r-1][c+1][0]+1:1;
				dp[r][c][1] = isIn(r-1,c-1)?dp[r-1][c-1][1]+1:1;
				for(int len = 0, max = Math.min(dp[r][c][0],dp[r][c][1]);len<max;len++){
					if(!isIn(r-2*len,c-len)||!isIn(r-2*len,c+len)) break;
					if(dp[r-len][c-len][0]>len&&dp[r-len][c+len][1]>len) answer = Math.max(answer,len+1);
				}
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static boolean isIn(int r, int c){
		return 0<=r&&r<R&&0<=c&&c<C;
	}
}