import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int SIZE = 100;
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[SIZE];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int duration = Integer.parseInt(st.nextToken()), value = Integer.parseInt(st.nextToken());
			for(int j=i+duration;j<=i+duration+50;j++){
				dp[j%SIZE] = Math.max(dp[j%SIZE],dp[i%SIZE]+value);
			}
		}
		bw.write(Long.toString(dp[N%SIZE]));
		bw.flush();
	}
}