import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] three = {0,0,0};
	static int p, answer, now, c=1;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean b = st.nextToken().charAt(0)=='0';
		for(int i=1;i<n;i++,c++){
			if(b!=(st.nextToken().charAt(0)=='0')) b = !b;
			else update();
		}
		update();
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static void update(){
		now -= three[p%3];
		now += three[p++%3] = c;
		answer = Math.max(answer,now);
		c = 0;
	}
}