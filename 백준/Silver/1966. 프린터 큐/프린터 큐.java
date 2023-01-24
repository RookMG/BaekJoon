import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public void solution() throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), answer = 0, max = -1;
		Deque<int[]> dq = new LinkedList<int[]>();
		PriorityQueue<Integer> maxValues = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			dq.offer(new int[] {num,i});
			maxValues.offer(-num);
		}
		max = -maxValues.poll();
		while(true) {
			int[] next = dq.pollFirst();
			if(next[0]==max) {
				answer++;
				if(next[1]==m) {break;}
				max = -maxValues.poll();
			}else {
				dq.offerLast(next);
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		new Main().solution();
	}
}