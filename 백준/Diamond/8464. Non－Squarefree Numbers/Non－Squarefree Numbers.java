import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long k;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		k = Long.parseLong(br.readLine());
		arr = new long[1000000];
		arr[1] = 1;
		for(int i=1;i<1000000;i++){
			for(int j=2*i;j<1000000;j+=i){
				arr[j] -= arr[i];
			}
		}
		long left, right, mid;
		for(left = 0, right = 1_000_000_000_000L, mid = 500_000_000_000L;left<right-1;mid = (left+right)/2){
			if(mid-solve(mid)<k) left = mid;
			else right = mid;
		}
		bw.write(Long.toString(right));
		bw.flush();
	}

	static long solve(long num){
		long ans = 0;
		for(long i=1;i*i<=num;i++) ans+=arr[(int)i]*num/(i*i);
		return ans;
	}
}