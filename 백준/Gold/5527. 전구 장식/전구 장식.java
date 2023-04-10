import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), answer = 0;
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken()), c = 1;
		ArrayList<Integer> l = new ArrayList<>();
		for(int i=1;i<n;i++){
			if(b!=Integer.parseInt(st.nextToken())){
				c++;
				b = 1-b;
			}else{
				l.add(c);
				c=1;
			}
		}
		l.add(c);
		for(int i=0;i<Math.min(3,l.size());i++) answer += l.get(i);
		for(int i=3, now = answer;i<l.size();i++){
			answer = Math.max(answer,now = now+l.get(i)-l.get(i-3));
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}