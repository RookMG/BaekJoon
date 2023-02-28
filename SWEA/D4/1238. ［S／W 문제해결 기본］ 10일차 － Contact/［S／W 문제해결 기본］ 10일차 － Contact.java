import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/**
 * @link :
 * @perf :
 * @category :
 * @author : tngks1995
 * @note : 주의사항
 */
class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean[][] graph;
	static boolean[] visit;
	static int max, maxdepth;
	static ArrayList<Integer> lasts;
	public static void main(String[] args) throws Exception{
		for(int test = 1;test<=10;test++) {
			bw.write("#");
			bw.write(Integer.toString(test));
			bw.write(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken())/2, start = Integer.parseInt(st.nextToken());
			graph = new boolean[101][101]; visit = new boolean[101]; max = -1; maxdepth = 0;
			lasts = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			Deque<Integer> q = new ArrayDeque<>();
			q.offerFirst(start);
			while(!q.isEmpty()){
				lasts.clear();
				for(int s=q.size();s>0;s--){
					int num = q.pollFirst();
					lasts.add(num);
					for(int i=1;i<=100;i++){
						if(graph[num][i]&&!visit[i]){
							visit[i] = true;
							q.offerLast(i);
						}
					}
				}
			}
			for(int i : lasts) max = Math.max(max,i);
			bw.write(Integer.toString(max));
			bw.write("\n");
		}
		bw.flush();
	}
}