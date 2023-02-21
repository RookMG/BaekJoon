import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final long p = 1_000_000_007L;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long[] fac = new long[4_000_001];
	static int idx = 1;
	public static void main(String[] args) throws Exception {
		int test = Integer.parseInt(br.readLine());
		for(int t = 0;t<test;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
			fac[0] = 1;
			long top = factorial(n), bot = factorial(n-k)*factorial(k)%p;
			bw.write(Long.toString(top*square(bot,p-2)%p));
			bw.write("\n");
		}
		bw.flush();
	}
	static long factorial(int num) {
		for(;idx<=num;idx++)
			fac[idx] = idx*fac[idx-1]%p;
		return fac[num];
	}
	static long square(long num, long pow) {
		if(pow==0) return 1;
		else if(pow==1) return num;
		long tmp = square(num,pow/2);
		return pow%2==1?tmp*tmp%p*num%p:tmp*tmp%p;
	}
}