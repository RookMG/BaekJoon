import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int V, E, idx;
	static int[] order;
	static ArrayList<ArrayList<Integer>> L;
	static ArrayList<int[]> answer;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		L = new ArrayList<>();
		idx = 1;
		order = new int[V+1];
		answer = new ArrayList<>();
		for(int i=0;i<=V;i++) L.add(new ArrayList<>());
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			L.get(a).add(b);
			L.get(b).add(a);
		}
		for(int i=1;i<=V;i++){
			if(order[i]==0){
				findLoop(i, 0);
			}
		}
		bw.write(Integer.toString(answer.size()));
		bw.write("\n");
		Collections.sort(answer,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
		for(int[] l : answer){
			bw.write(Integer.toString(l[0]));
			bw.write(" ");
			bw.write(Integer.toString(l[1]));
			bw.write("\n");
		}
		bw.flush();
	}
	static int findLoop(int now, int parent){
		int min = order[now] = idx++;
		for(int next:L.get(now)){
			if(order[next]==0){
				int nextMin = findLoop(next,now);
				min = Math.min(min,nextMin);
				if(nextMin>order[now]){
					answer.add(new int[]{Math.min(now,next),Math.max(now,next)});
				}
			}else if(next!=parent){
				min = Math.min(min,order[next]);
			}
		}
		return min;
	}
}