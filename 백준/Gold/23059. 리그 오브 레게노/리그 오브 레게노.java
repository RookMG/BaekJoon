import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		HashMap<Integer,String> id = new HashMap<>();
		ArrayList<Integer>[] outs = new ArrayList[n*2];
		boolean[] visit = new boolean[n*2];
		for(int i=0;i<2*n;i++) outs[i] = new ArrayList<>();
		int[] ins = new int[n*2];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken(), b = st.nextToken();
			if(!map.containsKey(a)){
				map.put(a,map.size());
				id.put(id.size(),a);
			}
			if(!map.containsKey(b)){
				map.put(b,map.size());
				id.put(id.size(),b);
			}
			int an = map.get(a), bn = map.get(b);
			outs[an].add(bn);
			ins[bn]++;
		}
		int valid = map.size();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=0;i<map.size();i++){
			if(ins[i]==0) q.offer(i);
		}
		PriorityQueue<String> ans = new PriorityQueue<>();
		while(!q.isEmpty()){
			ans.clear();
			for(int size=q.size();size>0;size--){
				int now = q.pollFirst();
				if(visit[now]) continue;
				visit[now] = true;
				valid--;
				ans.add(id.get(now));
				for(int i:outs[now]){
					if(--ins[i]==0) q.offerLast(i);
				}
			}
			while(!ans.isEmpty()) sb.append(ans.poll()).append('\n');
		}
		bw.write(valid==0?sb.toString():"-1");
		bw.flush();
	}
}