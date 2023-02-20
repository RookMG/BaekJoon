import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), answer = 0;
		for(int i=1<<n--;i>0;i>>=1) {
			if(r>=i) {
				r-=i;
				answer+=(i*i)<<1;
			}
			if(c>=i) {
				c-=i;
				answer+=i*i;
			}
		}
		System.out.println(answer);
	}
}