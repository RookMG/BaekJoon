import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] kits;
	static boolean[] visit;
	static int n,k,answer = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		kits = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) kits[i] = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		recur(n, 0);
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	
	static void recur(int times, int score) {
		if(times==0) {
			answer++;
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visit[i]&&score+kits[i]-k>=0) {
				visit[i] = true;
				recur(times-1, score+kits[i]-k);
				visit[i] = false;
			}
		}
	}
}