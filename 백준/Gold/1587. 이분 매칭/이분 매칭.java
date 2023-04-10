import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int 왼쪽 = Integer.parseInt(st.nextToken()), 오른쪽 = Integer.parseInt(st.nextToken()), 답 = 왼쪽/2 + 오른쪽/2;
		boolean 하나더 = false;
		if(왼쪽%2==1&&오른쪽%2==1){
			int 간선 = Integer.parseInt(br.readLine());
			for(int 입력=0;입력<간선;입력++){
				st = new StringTokenizer(br.readLine());
				if(Integer.parseInt(st.nextToken())%2==1&&Integer.parseInt(st.nextToken())%2==1) 하나더 = true;
			}
		}
		bw.write(Integer.toString(하나더?답+1:답));
		bw.flush();
	}
}