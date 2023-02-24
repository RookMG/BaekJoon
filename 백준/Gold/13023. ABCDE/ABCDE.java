import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static class Node{
		ArrayList<Integer> links = new ArrayList<>();
	}
	static boolean[] visit;
	static Node[] graph;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		graph = new Node[N];
		for(int i=0;i<N;i++) graph[i] = new Node();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			graph[a].links.add(b);
			graph[b].links.add(a);
		}
		for(int i=0;i<N;i++) {
			visit = new boolean[N];
			visit[i] = true;
			dfs(i,4);
		}
		bw.write('0');
		bw.flush();
	}
	static void dfs(int now, int depth) throws Exception {
		if(depth==0){
			bw.write('1');
			bw.flush();
			System.exit(0);
		}
		for(int next : graph[now].links){
			if(!visit[next]) {
				visit[next] = true;
				dfs(next, depth - 1);
				visit[next] = false;
			}
		}
	}
}