import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), g = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int num = Integer.parseInt(st.nextToken());
			g^=(num-1)%4>1?num-1+num%2*2:num;
		}
		bw.write(g==0?"cubelover":"koosaga");
		bw.flush();
	}
}