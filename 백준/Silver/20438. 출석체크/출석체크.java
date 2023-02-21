import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		boolean[] minsub = new boolean[n+3];
		int[] sum = new int[n+3];
		Arrays.fill(sum, 1);
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) minsub[Integer.parseInt(st.nextToken())] = true;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<q;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(minsub[now]) continue;
			for(int j=now;j<=n+2;j+=now) {
				if(minsub[j]) continue;
				sum[j] = 0;
			}
		}
		for(int i=1;i<=n+2;i++) sum[i] += sum[i-1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(Integer.toString(sum[Integer.parseInt(st.nextToken())-1]*-1+sum[Integer.parseInt(st.nextToken())]));
			bw.write("\n");
		}
		bw.flush();
	}
}