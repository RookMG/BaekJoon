import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static final int MOD = 998244353, BASE = 3, SIZE = 4194304, END = 1048576;
	public static void main(String[] args) throws Exception {
		long[] arr1 = new long[SIZE],arr2 = new long[SIZE];
		boolean[] prime = new boolean[END];
		Arrays.fill(prime,true);
		for(int i=2;i<1025;i++){
			if(!prime[i]) continue;
			for(int j=i*i;j<END;j+=i){
				prime[j] = false;
			}
		}
		for(int i=2;i<END;i++){
			if(!prime[i]) continue;
			arr1[i] = 1;
			if(i*2<END) arr2[i*2] = 1;
		}
		arr1 = fft(arr1,false);
		arr2 = fft(arr2,false);
		for(int i=0;i<SIZE;i++) arr1[i] = arr1[i]*arr2[i]%MOD;
		arr1 = fft(arr1,true);
		for(int i=Integer.parseInt(br.readLine());i>0;i--){
			int num = Integer.parseInt(br.readLine());
			sb.append(arr1[num]).append("\n");
		}
		bw.write(sb.toString());
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