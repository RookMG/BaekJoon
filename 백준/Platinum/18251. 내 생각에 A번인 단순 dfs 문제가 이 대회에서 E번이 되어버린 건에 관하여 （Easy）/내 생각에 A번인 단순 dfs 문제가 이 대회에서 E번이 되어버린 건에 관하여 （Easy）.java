import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long answer = Long.MIN_VALUE;

	static class Node implements Comparable<Node>{
		int x, y, cost;

		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(x,o.x);
		}
	}

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), h = 0, top = (n+1)>>1, spacing = n+1, size = 1, cnt = 0;
		Node[] nodes = new Node[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int cost = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(top+spacing*cnt++,h,cost);
			if(cnt==size){
				size*=2;
				spacing>>=1;
				top>>=1;
				cnt=0;
				h++;
			}
		}
		Arrays.sort(nodes);
		for(int up=0;up<h;up++){
			for(int down=up+1;down<=h;down++){
				long now = Long.MIN_VALUE, before = 0;
				for(int i=0;i<n;i++){
					if(up>nodes[i].y||down<=nodes[i].y) continue;
					now = Math.max(now,before = Math.max(nodes[i].cost, before+nodes[i].cost));
				}
				answer = Math.max(answer,now);
			}
		}
		bw.write(Long.toString(answer));
		bw.flush();
	}
}