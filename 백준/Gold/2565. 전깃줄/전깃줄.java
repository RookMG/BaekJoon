import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[501][501];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		for(int left=2;left<=500;left++){
			for(int right=2;right<=500;right++){
				dp[left][right] = Math.max(Math.max(dp[left-1][right],dp[left][right-1]),dp[left-1][right-1]+dp[left][right]);
			}
		}
		bw.write(Integer.toString(n-dp[500][500]));
		bw.flush();
	}
}