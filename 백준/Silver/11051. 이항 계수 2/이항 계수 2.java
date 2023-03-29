import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long N,K;
	static final int M = 10007;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		long answer = 1;
		for(;N>0||K>0;N/=M,K/=M){
			answer = answer*combination(N%M,K%M)%M;
		}
		bw.write(Long.toString(answer));
		bw.flush();
	}
	static long combination(long n, long k){
		long top = 1, div = 1;
		for(long i=n-k+1;i<=n;i++) top=top*i%M;
		for(long i=2;i<=k;i++) div=div*i%M;
		n=1;
		k=M-2;
		for(;k>0;k>>=1,div=div*div%M){
			if((k&1)!=0) n= n*div%M;
		}
		return top*n%M;
	}
}