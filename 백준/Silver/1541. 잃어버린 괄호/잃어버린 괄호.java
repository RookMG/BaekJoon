import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st, seg;
	public static void main(String[] args) throws Exception {
		String line = br.readLine();
		int answer = 0;
		st = new StringTokenizer(line,"-");
		int size = st.countTokens();
		for(int i=0;i<size;i++){
			int now = 0;
			seg = new StringTokenizer(st.nextToken(),"+");
			while(seg.hasMoreTokens()) now += Integer.parseInt(seg.nextToken());
			answer += i==0?now:-now;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}