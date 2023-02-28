import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] parent;
	static boolean[] visit;
	static class Node{
		int num;
		ArrayList<Node> child;
		Node(int num){
			this.num = num;
			child = new ArrayList<>();
		}
		void dfs() throws Exception {
			visit[num] = true;
			for(Node n: child) {
				if(visit[n.num])
					continue;
				n.dfs();
				bw.write(Integer.toString(num));
				bw.write(" ");
				bw.write(Integer.toString(n.num));
				bw.write("\n");
			}
		}
	}
	static class Line implements Comparable<Line>{
		int cost, small, big;
		Line(int cost, int small, int big){
			this.cost = cost;
			this.small = small;
			this.big = big;
		}
		@Override
		public int compareTo(Line o) {
			return Double.compare(cost,o.cost)*-1;
		}
	}
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), left = n-1;
		long answer = 0;
		int[][] chef = new int[n][2];
		PriorityQueue<Line> pq = new PriorityQueue<>();
		Node[] tree = new Node[n+1];
		parent = new int[n];
		visit = new boolean[n+1];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			chef[i][0] = Integer.parseInt(st.nextToken());
			chef[i][1] = Integer.parseInt(st.nextToken());
			parent[i] = i;
			tree[i+1] = new Node(i+1);
		}
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				pq.offer(new Line((chef[i][1]+chef[j][1])/Math.abs(chef[i][0]-chef[j][0]),i,j));
			}
		}
		int num = pq.peek().big+1;
		while(left>0){
			Line l = pq.poll();
			if(findParent(l.small)!=findParent(l.big)){
				left--;
				answer +=l.cost;
				parent[findParent(l.big)] = findParent(l.small);
				tree[1+l.big].child.add(tree[1+l.small]);
				tree[1+l.small].child.add(tree[1+l.big]);
			}
		}
		bw.write(Long.toString(answer));
		bw.write("\n");
		tree[num].dfs();
		bw.flush();
	}
	static int findParent(int num){
		return parent[num]=(parent[num]==num?num:findParent(parent[num]));
	}
}