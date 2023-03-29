import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		int[] dp = new int[k+1];
		Arrays.fill(dp,10001);
		dp[0] = 0;
		for(int i=0;i<n;i++){
			int num = Integer.parseInt(br.readLine());
			for(int j=num;j<=k;j++) dp[j] = Math.min(dp[j],dp[j-num]+1);
		}
		bw.write(dp[k]==10001?"-1":Integer.toString(dp[k]));
		bw.flush();
	}
}