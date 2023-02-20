import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), half = m/2;
		long[][] answer = new long[n][n], input = new long[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				input[i][j] = Long.parseLong(st.nextToken())*-1L;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i>=half&&j>=half&&i<n-half&&j<n-half){
					answer[i][j] = input[i-half][j-half];
					if(i>half) answer[i][j] -= input[i-half-1][j-half];
					if(j>half) answer[i][j] -= input[i-half][j-half-1];
					if(i>half&&j>half) answer[i][j] += input[i-half-1][j-half-1];
					if(i>=m) answer[i][j] += answer[i-m][j];
					if(j>=m) answer[i][j] += answer[i][j-m];
					if(i>=m&&j>=m) answer[i][j] -= answer[i-m][j-m];
				}
				bw.write(Long.toString(answer[i][j]));
				bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}