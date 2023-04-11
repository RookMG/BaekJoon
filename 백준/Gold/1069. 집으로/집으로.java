import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
		double dist = Math.sqrt(x*x+y*y), answer = 0;
		boolean jump = d>t;
		while(jump&&Math.abs(dist)>=d){
			dist-=d;
			answer+=t;
		}
		if(jump) answer+=Math.min(Math.min(answer==0?2*t:t,t+Math.abs(d-Math.abs(dist))),Math.abs(dist));
		bw.write(Double.toString(jump?answer:dist));
		bw.flush();
	}
}