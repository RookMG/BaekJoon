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
		int n = Integer.parseInt(br.readLine());
		long sum = 0L;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			sum += Long.parseLong(st.nextToken());
		}
		for(long l = 1L<<62;l>=1;l>>=1){
			if((sum&l)!=0L){
				bw.write(Long.toString(l));
				break;
			}
		}
		bw.flush();
	}
}