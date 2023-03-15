import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		PriorityQueue<String> pq = new PriorityQueue<>();
		char[][] map = new char[C][R];
		for(int r=0;r<R;r++){
			String line = br.readLine();
			st = new StringTokenizer(line,"#");
			while(st.hasMoreTokens()){
				String tkn = st.nextToken();
				if(tkn.length()>1) pq.add(tkn);
			}
			for(int c=0;c<C;c++){
				map[c][r] = line.charAt(c);
			}
		}
		for(int c=0;c<C;c++){
			st = new StringTokenizer(String.valueOf(map[c]),"#");
			while(st.hasMoreTokens()){
				String tkn = st.nextToken();
				if(tkn.length()>1) pq.add(tkn);
			}
		}
		bw.write(pq.poll());
		bw.flush();
	}
}