import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		long n = Long.parseLong(br.readLine()), mod = n;
		for(long l=2;l<=mod;l++) {
			if(mod%l==0) {
				while(mod%l==0)
					mod/=l;
				n = n/l*(l-1);
			}
			if(l>=1000000) {
				n = n/mod*(mod-1);
				break;
			}
		}
		bw.write(Long.toString(n));
		bw.flush();
	}
}