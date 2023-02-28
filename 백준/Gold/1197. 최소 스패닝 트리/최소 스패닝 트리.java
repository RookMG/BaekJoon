import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static class Node implements Comparable<Node>{
		int num;
		long value;
		public Node(int num, long value) {
			this.num = num;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return Long.compare(value,o.value);
		}
	}
	static class Links{
		ArrayList<int[]> links = new ArrayList<>();
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), cnt = 0;
		long answer = 0;
		boolean[] visit = new boolean[v+1];
		long[] costs = new long[v+1];
		Links[] l = new Links[v+1];
		for(int i=1;i<=v;i++) l[i] = new Links();
		for(int i=0;i<e;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			l[a].links.add(new int[]{b,c});
			l[b].links.add(new int[]{a,c});
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(costs, Long.MAX_VALUE);
		pq.offer(new Node(1,0));
		while(!pq.isEmpty()) {
			Node head = pq.poll();
			if(visit[head.num]) continue;
			visit[head.num] = true;
			answer+=head.value;
			if(++cnt == v) break;
			for(int[] link : l[head.num].links){
				if(!visit[link[0]] && costs[link[0]] > link[1]) {
					costs[link[0]] = link[1];
					pq.offer(new Node(link[0], costs[link[0]]));
				}
			}
		}
		bw.write(Long.toString(answer));
		bw.write("\n");
		bw.flush();
	}
}