import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int END = 100001;
	static int n, k;
	static boolean[] visit;
	static class Node{
		int now, cnt;
		Node back;
		Node(int now, int cnt, Node back){
			this.now = now;
			this.cnt = cnt;
			this.back = back;
		}
	}
	static Deque<Node> q = new ArrayDeque<>();
	static Deque<Integer> answer = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine()); n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		visit = new boolean[END]; visit[n]=true;
		q.offerLast(new Node(n,0,null));
		while(!q.isEmpty()){
			int now = q.peekFirst().now, cnt = q.peekFirst().cnt;
			Node back = q.pollFirst();
			if(now==k){
				bw.write(Integer.toString(cnt));
				bw.write("\n");
				while(back!=null){
					answer.offerFirst(back.now);
					back = back.back;
				}
				while(!answer.isEmpty()) {
					bw.write(Integer.toString(answer.pollFirst()));
					bw.write(" ");
				}
				bw.flush();
				return;
			}
			next(2*now,cnt,back);
			next(now+1,cnt,back);
			next(now-1,cnt,back);
		}
	}
	static void next(int num, int cnt, Node back){
		if(0<=num&&num<END&&!visit[num]){
			visit[num] = true;
			q.offerLast(new Node(num, cnt+1, back));
		}
	}
}