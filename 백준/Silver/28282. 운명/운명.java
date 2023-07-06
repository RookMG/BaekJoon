import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken()), ans = X*X;
		int K = Integer.parseInt(st.nextToken());
		long[][] arr = new long[K+1][2];
		st = new StringTokenizer(br.readLine());
		for(int s=0;s<2;s++) for(int i=0;i<X;i++) arr[Integer.parseInt(st.nextToken())][s]++;
		for(int i=1;i<=K;i++) ans -= arr[i][0]*arr[i][1];
		bw.write(Long.toString(ans));
		bw.flush();
	}
}