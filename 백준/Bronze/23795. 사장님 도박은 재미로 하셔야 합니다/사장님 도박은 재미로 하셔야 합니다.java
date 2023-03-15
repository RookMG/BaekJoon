import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = 0;
		while(true){
			int i = Integer.parseInt(br.readLine());
			if(i==-1) break;
			n+=i;
		}
		bw.write(Integer.toString(n));
		bw.flush();
	}
}