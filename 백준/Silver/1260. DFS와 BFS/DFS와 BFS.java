import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static class Node{
		boolean sorted = false;
		ArrayList<Integer> links = new ArrayList<>();
	}
	static Node[] graph;
	static boolean[] visit;
	static Deque<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
		graph = new Node[N+1];
		for(int i=1;i<=N;i++) graph[i] = new Node();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			graph[a].links.add(b);
			graph[b].links.add(a);
		}
		visit = new boolean[N+1];
		visit[V] = true;
		dfs(V);
		bw.write("\n");
		visit = new boolean[N+1];
		visit[V] = true;
		q.add(V);
		while(!q.isEmpty()){
			bw.write(Integer.toString(q.peekFirst()));
			bw.write(" ");
			for(int next : graph[q.pollFirst()].links){
				if(!visit[next]){
					visit[next] = true;
					q.offerLast(next);
				}
			}
		}
		bw.flush();
	}
	static void dfs(int now) throws Exception {
		if(!graph[now].sorted){
			Collections.sort(graph[now].links);
			graph[now].sorted = true;
		}
		bw.write(Integer.toString(now));
		bw.write(" ");
		for(int next : graph[now].links){
			if(!visit[next]){
				visit[next] = true;
				dfs(next);
			}
		}
	}
}