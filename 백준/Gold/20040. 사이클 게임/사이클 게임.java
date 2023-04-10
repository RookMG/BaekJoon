import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), answer = 0;
		parent = new int[n];
		for(int i=1;i<n;i++) parent[i] = i;
		for(int i=1;i<=m;i++){
			st = new StringTokenizer(br.readLine());
			int ap = findP(Integer.parseInt(st.nextToken())), bp = findP(Integer.parseInt(st.nextToken()));
			if(ap==bp){
				answer = i;
				break;
			}
			parent[bp]=ap;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
	static int findP(int num){
		return parent[num]=num==parent[num]?num:findP(parent[num]);
	}
}