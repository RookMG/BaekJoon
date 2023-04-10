import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		char[] p = br.readLine().toCharArray();
		boolean valid = p[0]!='0';
		int[] dp = new int[p.length+1];
		dp[0] = dp[1] = 1;
		for(int i=1,t;i<p.length;i++){
			t = (p[i-1]-'0')*10+(p[i]-'0');
			if(p[i]!='0') dp[i+1] = dp[i];
			if(10<=t&&t<=26) dp[i+1] = (dp[i+1]+dp[i-1])%1000000;
			if(t==0) valid = false;
		}
		bw.write(Integer.toString(valid?dp[p.length]:0));
		bw.flush();
	}
}