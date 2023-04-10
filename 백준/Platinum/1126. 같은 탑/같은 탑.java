import java.io.*;
import java.util.*;;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] height = new int[n+1];
		int[][] dp = new int[n+1][500001];
		for(int i=1;i<=n;i++) height[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(dp[0],-1);
		dp[0][0] = 0;
		for(int i=1;i<=n;i++){
			for(int j=0;j<=500000;j++){
				dp[i][j] = dp[i-1][j];
				if(j-height[i]>=0&&dp[i-1][j-height[i]]!=-1){
					dp[i][j] = Math.max(dp[i][j],dp[i-1][j-height[i]]+height[i]);
				}
				if(height[i]-j>=0&&dp[i-1][height[i]-j]!=-1){
					dp[i][j] = Math.max(dp[i][j],dp[i-1][height[i]-j]+j);
				}
				if(j+height[i]<=500000&&dp[i-1][j+height[i]]!=-1){
					dp[i][j] = Math.max(dp[i][j],dp[i-1][j+height[i]]);
				}
			}
		}
		bw.write(Integer.toString(dp[n][0]>0?dp[n][0]:-1));
		bw.flush();
	}
}