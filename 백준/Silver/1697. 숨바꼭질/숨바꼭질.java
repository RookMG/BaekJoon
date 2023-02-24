import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int END = 100001;
	static boolean[] visit;
	static Deque<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
		visit = new boolean[END];
		q.offerLast(new int[]{n,0});
		visit[n]=true;
		while(!q.isEmpty()){
			int[] now = q.pollFirst();
			if(now[0]==k){
				System.out.println(now[1]);
				return;
			}
			next(2*now[0],now[1]);
			next(now[0]+1,now[1]);
			next(now[0]-1,now[1]);
		}
	}
	static void next(int num, int cnt){
		if(0<=num&&num<END&&!visit[num]){
			visit[num] = true;
			q.offerLast(new int[]{num, cnt+1});
		}
	}
}