import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int MOD = 998244353, BASE = 3;
	static final char[] rcp = {'R','S','P'};
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		char[] s1 = br.readLine().toCharArray(), s2 = br.readLine().toCharArray();
		int llen = Math.max(s1.length,s2.length), flen = 1;
		for(;flen<2*llen;flen<<=1);
		long[] arr1, arr2, conv, out = new long[flen];
		for(int c=0;c<3;c++) {
			arr1 = new long[flen];
			arr2 = new long[flen];
			conv = new long[flen];
			for (int i = 0; i < s1.length; i++) arr1[s1.length - 1 - i] = (s1[i]==rcp[c])?1:0;
			for (int i = 0; i < s2.length; i++) arr2[i] = (s2[i]==rcp[(c+2)%3])?1:0;
			arr1 = fft(arr1, false);
			arr2 = fft(arr2, false);
			for (int i = 0; i < flen; i++) conv[i] = (arr1[i] * arr2[i]) % MOD;
			conv = fft(conv, true);
			for(int i=0;i<flen;i++) out[i] += conv[i];
		}
		long answer = 0;
		for (int i = 0; i < s1.length; i++) answer = Math.max(answer,out[i]);
		bw.write(Long.toString(answer));
		bw.flush();
	}
	static long[] fft(long[] data, boolean inv){
		long[] arr = Arrays.copyOf(data,data.length);
		for(int i=1, j=0;i<arr.length;i++){
			int bit = arr.length/2;
			while(true){
				j^=bit;
				if((j&bit)>0) break;
				bit>>>=1;
			}
			if(i<j){
				long tmp = arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
		}
		for(int flen=2;flen<=arr.length;flen*=2){
			int halflen = flen/2;
			long unit = pow(BASE,(MOD-1)/flen,MOD);
			if(inv) unit = pow(unit,MOD-2,MOD);
			for(int p=0;p<arr.length;p+=flen){
				long w = 1;
				for(int n=0;n<halflen;n++){
					long t1 = (arr[p+n]+arr[p+n+halflen]*w)%MOD;
					long t2 = (arr[p+n]-arr[p+n+halflen]*w)%MOD;
					arr[p+n] = (t1+MOD)%MOD;
					arr[p+n+halflen] = (t2+MOD)%MOD;
					w = (w*unit)%MOD;
				}
			}
		}
		if(inv){
			long invlen = pow(arr.length,MOD-2,MOD);
			for(int i=0;i<arr.length;i++){
				arr[i] = arr[i]*invlen%MOD;
			}
		}
		return arr;
	}
	static long pow(long base, int exp, int mod){
		if(exp==1) return base;
		if(exp==0) return 1;
		long res = pow(base,exp/2,mod);
		res = (res*res)%mod;
		if(exp%2==1) res = (res*base)%mod;
		return (int)res;
	}
}