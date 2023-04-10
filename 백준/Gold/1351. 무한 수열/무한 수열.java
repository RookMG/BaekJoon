import java.io.*;
import java.util.*;;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static HashMap<Long,Long> map;
	static long N, P, Q;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		map = new HashMap<>();
		map.put(0L,1L);
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		bw.write(Long.toString(recur(N)));
		bw.flush();
	}
	static long recur(long n){
		if(map.containsKey(n)) return map.get(n);
		long ans =recur(n/P)+recur(n/Q);
		map.put(n,ans);
		return ans;
	}
}