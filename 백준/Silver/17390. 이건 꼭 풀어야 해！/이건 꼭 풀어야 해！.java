import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<n;i++) {
			arr[i+1]=arr[i]+pq.poll();
		}
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			sb.append(arr[b]-arr[a-1]).append("\n");
		}
		System.out.print(sb);
	}
}