import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), answer = 0;
		int[][][] dp = new int[n+1][10][1<<10];
		for(int i=1;i<10;i++) dp[1][i][1<<i] = 1;
		for(int i=2;i<=n;i++){
			for(int num=0;num<10;num++){
				for(int mask=1;mask<(1<<10);mask++){
					if(num>0) dp[i][num][mask|(1<<num)] = (dp[i][num][mask|(1<<num)]+dp[i-1][num-1][mask])%MOD;
					if(num<9) dp[i][num][mask|(1<<num)] = (dp[i][num][mask|(1<<num)]+dp[i-1][num+1][mask])%MOD;
				}
			}
		}
		for(int num=0;num<10;num++) answer = (answer+dp[n][num][(1<<10)-1])%MOD;
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}