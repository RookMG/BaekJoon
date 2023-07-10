import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[] visit, finish;
	static int[] link;
	static int n, answer;

	public static void main(String[] args) throws Exception {
		for(int T = Integer.parseInt(br.readLine());T>0;T--) {
			answer = n = Integer.parseInt(br.readLine());
			visit = new boolean[n+1];
			finish = new boolean[n+1];
			link = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++){
				int num = Integer.parseInt(st.nextToken());
				link[i] = num;
			}
			for (int i = 1; i <= n; i++) {
				if(!visit[i]) dfs(i);
			}
			sb.append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static void dfs(int now){
		visit[now] = true;
		int next = link[now];
		if(visit[next]){
			int tmp = 1, nlink = link[next];
			while(true){
				if(finish[nlink]) return;
				if(nlink==next) {
					answer -= tmp;
					finish[nlink] = true;
					return;
				}
				tmp++;
				finish[nlink] = true;
				nlink=link[nlink];
			}
		}
		dfs(next);
	}
}