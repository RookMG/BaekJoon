import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> squares = new ArrayList<>();
		for(int i=1;i*i<=N;i++) squares.add(i*i);
		int[] dp = new int[N+1];
		Arrays.fill(dp,100001);
		dp[0] = 0;
		for(int i=1;i<=N;i++){
			for(int j:squares){
				if(j>i) break;
				dp[i] = Math.min(dp[i],dp[i-j]+1);
			}
		}
		bw.write(Integer.toString(dp[N]));
		bw.flush();
	}
}