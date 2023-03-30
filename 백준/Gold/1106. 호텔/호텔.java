import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C+101];
		Arrays.fill(dp,1_000_000);
		dp[0] = 0;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			for(int j=v;j<C+101;j++){
				dp[j] = Math.min(dp[j],dp[j-v]+c);
			}
		}
		int[] ans = Arrays.copyOfRange(dp,C,C+100);
		Arrays.sort(ans);
		bw.write(Integer.toString(ans[0]));
		bw.flush();
	}
}