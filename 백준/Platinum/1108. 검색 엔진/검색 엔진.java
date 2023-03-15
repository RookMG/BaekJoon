import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int E, idx;
	static long[] score;
	static boolean[] visit;
	static HashMap<String,Integer> toNum;
	static ArrayList<Integer> line;
	static ArrayList<HashSet<Integer>> L, RL;
	static Deque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		L = new ArrayList<>();
		RL = new ArrayList<>();
		idx = 1;
		for(int i=0;i<=1200;i++){
			L.add(new HashSet<>());
			RL.add(new HashSet<>());
		}
		toNum = new HashMap<>();
		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int a = getNum();
			for(int j = Integer.parseInt(st.nextToken());j>0;j--) {
				int b = getNum();
				RL.get(a).add(b);
				L.get(b).add(a);
			}
		}
		score = new long[idx];
		visit = new boolean[idx];
		for(int i=1;i<idx;i++){
			score[i] = 1;
			if(!visit[i]){
				visit[i] = true;
				dfs(i);
			}
		}
		visit = new boolean[idx];
		while(!stack.isEmpty()){
			int now = stack.pollLast();
			line = new ArrayList<>();
			if(!visit[now]){
				visit[now] = true;
				group(now);
			}
			for(int i=0;i<line.size();i++){
				for(int j=0;j<line.size();j++){
					L.get(line.get(i)).remove(line.get(j));
					RL.get(line.get(i)).remove(line.get(j));
				}
			}
		}
		stack.clear();
		for(int i=1;i<idx;i++){
			if(RL.get(i).size()==0){
				stack.offer(i);
			}
		}
		st = new StringTokenizer(br.readLine());
		int target = getNum();
		while(!stack.isEmpty()){
			int now =stack.pollFirst();
			if(now==target) break; //??
			for(int next:L.get(now)) {
				score[next] += score[now];
				RL.get(next).remove(now);
				if (RL.get(next).isEmpty()) {
					stack.offer(next);
				}
			}
		}
		bw.write(Long.toString(score[target]));
		bw.flush();
	}
	static int getNum(){
		String key = st.nextToken();
		if(!toNum.containsKey(key)){
			toNum.put(key,idx++);
		}
		return toNum.get(key);
	}
	static void dfs(int now){
		for(int next:RL.get(now)){
			if(!visit[next]){
				visit[next] = true;
				dfs(next);
			}
		}
		stack.offerLast(now);
	}

	static void group(int now){
		for(int next:L.get(now)){
			if(!visit[next]){
				visit[next] = true;
				group(next);
			}
		}
		line.add(now);
	}
}