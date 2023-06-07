import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		solve();
		bw.write(sb.toString());
		bw.flush();
	}
	static void solve(){
		if(M+K>N+1||N>M*K){
			sb.append("-1");
			return;
		}
		for(int i=K;i>0;i--) sb.append(i).append(' ');
		if(M==1) return;
		int size = (N-K)/(M-1), remain = (N-K)%(M-1), last = K;
		if(remain>0) size++;
		for(int i=0;i<M-1;i++){
			for(int cnt = size;cnt>0;cnt--){
				sb.append(last+cnt).append(' ');
			}
			last += size;
			if(--remain==0) size--;
		}
	}
}