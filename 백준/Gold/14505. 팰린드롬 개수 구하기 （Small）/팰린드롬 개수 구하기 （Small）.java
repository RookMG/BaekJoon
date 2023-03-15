import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		char[] line = br.readLine().toCharArray();
		int[][] dp = new int[line.length][line.length];
		dp[0][0] = 1;
		for(int i=1;i<line.length;i++){
			dp[i][i] = 1;
			dp[i-1][i] = line[i-1]==line[i]?3:2;
		}
		for(int size=2;size<line.length;size++){
			for(int left = 0;left<line.length-size;left++){
				int right = left+size;
				dp[left][right] = dp[left+1][right]+dp[left][right-1]+(line[left]==line[right]?1:-dp[left+1][right-1]);
			}
		}
		bw.write(Integer.toString(dp[0][line.length-1]));
		bw.flush();
	}
}