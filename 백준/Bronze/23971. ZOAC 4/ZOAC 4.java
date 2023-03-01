import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), as = Integer.parseInt(st.nextToken()), bs = Integer.parseInt(st.nextToken());
		bw.write(Integer.toString((a+as)/(as+1)*((b+bs)/(bs+1))));
		bw.flush();
	}
}