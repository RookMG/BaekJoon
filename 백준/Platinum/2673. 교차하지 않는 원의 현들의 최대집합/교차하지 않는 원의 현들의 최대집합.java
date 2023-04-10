import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] link = new int[101][101], dp = new int[101][101];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			link[a][b] = 1;
			link[b][a] = 1;
		}
		for(int diff = 1;diff<100;diff++){
			for(int start = 1, end = start+diff;end<=100;start++,end++){
				for(int mid = start;mid<end;mid++){
					dp[start][end] = Math.max(dp[start][end],dp[start][mid]+dp[mid+1][end]+link[start][end]);
				}
			}
		}
		bw.write(Integer.toString(dp[1][100]));
		bw.flush();
	}
}