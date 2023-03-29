import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), answer = -1000, before = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int now = Integer.parseInt(st.nextToken());
			answer = Math.max(answer,before = Math.max(now, before+now));
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}