import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int L, C, c1, c2;
	static char[] dict;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
		dict = new char[C]; visit = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) dict[i] = st.nextToken().charAt(0);
		Arrays.sort(dict);
		combination(0,0);
		bw.flush();
	}
	static void combination(int count, int start) throws Exception {
		if(count==L){
			if(c1>=1&&c2>=2) bw.write(sb.append("\n").toString());
			return;
		}
		for(int i=start;i<C;i++){
			if(visit[i]) continue;
			visit[i] = true;
			sb.append(dict[i]);
			if("aeiou".indexOf(dict[i])<0) c2++;
			else c1++;
			combination(count+1,i+1);
			visit[i] = false;
			sb.setLength(count);
			if("aeiou".indexOf(dict[i])<0) c2--;
			else c1--;
		}
	}
}