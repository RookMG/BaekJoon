import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int V, E, cnt, idx;
	static int[] order;
	static boolean[] answer;
	static ArrayList<ArrayList<Integer>> L;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		L = new ArrayList<>();
		cnt = 0;
		idx = 1;
		order = new int[V+1];
		answer = new boolean[V+1];
		for(int i=0;i<=V;i++) L.add(new ArrayList<>());
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			L.get(a).add(b);
			L.get(b).add(a);
		}
		for(int i=1;i<=V;i++){
			if(order[i]==0){
				findLoop(i, true);
			}
		}
		bw.write(Integer.toString(cnt));
		bw.write("\n");
		for(int i=1;i<=V;i++){
			if(answer[i]){
				bw.write(Integer.toString(i));
				bw.write(" ");
			}
		}
		bw.flush();
	}
	static int findLoop(int now, boolean start){
		int min = order[now] = idx++, child = 0;
		for(int next:L.get(now)){
			if(order[next]==0){
				child++;
				int nextMin = findLoop(next,false);
				min = Math.min(min,nextMin);
				if(!start&&nextMin>=order[now]&&!answer[now]){
					answer[now] = true;
					cnt++;
				}
			}else{
				min = Math.min(min,order[next]);
			}
		}
		if(start && !answer[now] && child>1){
			answer[now] = true;
			cnt++;
		}
		return min;
	}
}