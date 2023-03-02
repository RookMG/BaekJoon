import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
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
		int[] distance = new int[V+1];
		boolean[] visit = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		int min, current;
		for(int c=1;c<=V;c++) {
			// step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = Integer.MAX_VALUE;
			for(int i=1;i<=V;i++) {
				if(!visit[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			if(current==-1) break;
			visit[current] = true;

			for(int[] link : links.get(current)){
				distance[link[0]] = Math.min(distance[link[0]],min+link[1]);
			}
		}
		for(int c=1;c<=V;c++) {
			bw.write(distance[c]==Integer.MAX_VALUE?"INF":Integer.toString(distance[c]));
			bw.write("\n");
		}
		bw.flush();
	}
}