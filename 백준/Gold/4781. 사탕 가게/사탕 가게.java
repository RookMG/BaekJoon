import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		for(String input = br.readLine();;input = br.readLine()){
			if(input.contains("0 0.00")) break;
			st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken()), size = (int)(Double.parseDouble(st.nextToken())*100 + 0.5);
			int[] dp = new int[size+1];
			for(int i=0;i<n;i++){
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken()), cost = (int)(Double.parseDouble(st.nextToken())*100 + 0.5);
				for(int j=cost;j<=size;j++){
					dp[j] = Math.max(dp[j],dp[j-cost]+v);
				}
			}
			sb.append(dp[size]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}