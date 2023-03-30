import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] link = new int[301][301], dp = new int[301][301];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
			link[100+c-r][100+c+r] = 1;
		}
		for(int diff = 1;diff<300;diff++){
			for(int start = 1, end = start+diff;end<=300;start++,end++){
				for(int mid = start+1;mid<end;mid++){
					dp[start][end] = Math.max(dp[start][end],dp[start][mid]+dp[mid][end]+link[start][end]);
				}
			}
		}
		bw.write(Integer.toString(n-dp[1][300]));
		bw.flush();
	}
}