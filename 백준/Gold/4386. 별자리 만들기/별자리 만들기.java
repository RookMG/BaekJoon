import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] parent;
	static class Line implements Comparable<Line>{
		double cost;
		int small, big;
		Line(double cost, int small, int big){
			this.cost = cost;
			this.small = small;
			this.big = big;
		}
		@Override
		public int compareTo(Line o) {
			return Double.compare(cost,o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), left = n-1;
		double answer = 0.0;
		double[][] star = new double[n][2];
		PriorityQueue<Line> pq = new PriorityQueue<>();
		parent = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
			parent[i] = i;
		}
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				pq.offer(new Line(Math.sqrt(Math.pow(star[i][0]-star[j][0],2)+Math.pow(star[i][1]-star[j][1],2)),i,j));
			}
		}
		while(left>0){
			Line l = pq.poll();
			if(findParent(l.small)!=findParent(l.big)){
				left--;
				answer+=l.cost;
				parent[findParent(l.big)] = findParent(l.small);
			}
		}
		bw.write(Double.toString(answer));
		bw.flush();
	}
	static int findParent(int num){
		return parent[num]=(parent[num]==num?num:findParent(parent[num]));
	}
}