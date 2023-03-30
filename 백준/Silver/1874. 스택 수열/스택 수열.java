import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int visit = 0, i=0;i<n;i++){
			int now = Integer.parseInt(br.readLine());
			while(visit<now){
				stack.offerLast(++visit);
				sb.append("+\n");
			}
			if(!stack.isEmpty()&&stack.peekLast()==now){
				stack.pollLast();
				sb.append("-\n");
			}else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}