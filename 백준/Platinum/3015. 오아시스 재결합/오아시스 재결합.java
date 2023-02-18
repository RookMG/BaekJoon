import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		long answer = 0;
		int n = Integer.parseInt(br.readLine()), now, dup;
		Deque<int[]> stack = new ArrayDeque<>();
		for(int i=0;i<n;i++){
			now = Integer.parseInt(br.readLine());
			dup = 1;
			while(!stack.isEmpty()&&stack.peekFirst()[0]<now){
				answer+=stack.pollFirst()[1];
			}
			if(!stack.isEmpty()){
				if(stack.peekFirst()[0]==now){
					dup = stack.pollFirst()[1];
					answer += dup++;
					if(!stack.isEmpty()) answer++;
				}else{
					answer++;
				}
			}
			stack.offerFirst(new int[]{now,dup});
		}
		bw.write(Long.toString(answer));
		bw.flush();
	}
}