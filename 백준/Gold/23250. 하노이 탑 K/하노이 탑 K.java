import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long n,k,total;
	static void hanoi(long from, long goal){
		while(true) {
			total >>= 1L;
			switch(Long.compare(total+1L, k)) {
				case 1:
					goal = 6-from-goal;
					break;
				case 0:
					sb.append(from).append(" ").append(goal).append("\n");
					return;
				case -1:
					k-= (total+1L);
					from = 6-from-goal;
					break;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken()); k = Long.parseLong(st.nextToken());
		total = (1L<<n)-1L;
		hanoi(1,3);
		System.out.print(sb);
	}
}