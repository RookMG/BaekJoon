import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, answer;
	static int[] route = new int[52];
	static int[][] cap = new int[52][52], cur = new int[52][52];
	static ArrayDeque<Integer> dq = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = st.nextToken().charAt(0)-'a', e = st.nextToken().charAt(0)-'a', c = Integer.parseInt(st.nextToken());
			if(s<0) s+=58;
			if(e<0) e+=58;
			cap[s][e] += c;
			cap[e][s] += c;
		}
		while(true){
			Arrays.fill(route,-1);
			route[26] = 26;
			dq.clear();
			dq.offer(26);
			while(!dq.isEmpty()){
				int now = dq.pollFirst();
				for(int i=0;i<52;i++){
					if(cap[now][i]-cur[now][i]>0 && route[i] == -1){
						dq.offer(i);
						route[i] = now;
						if(i==51) break;
					}
				}
			}
			if(route[51]==-1) break;
			int flow = Integer.MAX_VALUE;
			for(int i=51;i!=26;i=route[i]){
				flow = Math.min(flow, cap[route[i]][i]-cur[route[i]][i]);
			}
			for(int i=51;i!=26;i=route[i]){
				cur[route[i]][i] += flow;
				cur[i][route[i]] -= flow;
			}
			answer += flow;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}