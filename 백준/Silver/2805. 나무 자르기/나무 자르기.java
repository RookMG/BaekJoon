import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		long mid = 0, left , right , now;
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			tree[i] = Integer.parseInt(st.nextToken());
		}
		for(left = 0,right=1_000_000_000;left<=right;){
			mid = (left+right)/2;
			now = 0;
			for(int t:tree){
				now += Math.max(0,t-mid);
			}
			if(M<=now) left = mid+1;
			else right = mid-1;
		}
		bw.write(Long.toString(right));
		bw.flush();
	}
}