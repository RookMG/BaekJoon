import java.io.*;
import java.util.StringTokenizer;
public class Main{
	static int[] parent;
	static int findParent(int i) {
		return parent[i]==i?parent[i]:(parent[i]=findParent(parent[i]));
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			bw.write("Scenario ");
			bw.write(Integer.toString(test));
			bw.write(":\n");
			int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
			parent = new int[N];
			for(int i=0;i<N;i++) parent[i] = i;
			for(int i=0;i<K;i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				parent[findParent(Math.max(a, b))]=findParent(Math.min(a, b));
			}
			int M = Integer.parseInt(br.readLine());
			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				bw.write(findParent(a)==findParent(b)?"1\n":"0\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}