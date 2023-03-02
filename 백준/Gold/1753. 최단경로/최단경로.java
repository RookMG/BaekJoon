import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), start = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<int[]>> links = new ArrayList<>();
		for(int i=0;i<=V;i++) links.add(new ArrayList<>());
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
			links.get(from).add(new int[]{to,weight});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1],o2[1]);
			}
		});
		int[] distance = new int[V+1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.offer(new int[]{start,0});
		while(!pq.isEmpty()){
			int[] minLink = pq.poll();
			for(int[] link : links.get(minLink[0])){
				if(distance[link[0]]>minLink[1]+link[1]) pq.offer(new int[]{link[0], distance[link[0]] = minLink[1]+link[1]});
			}
		}
		for(int c=1;c<=V;c++) {
			bw.write(distance[c]==INF?"INF":Integer.toString(distance[c]));
			bw.write("\n");
		}
		bw.flush();
	}
}