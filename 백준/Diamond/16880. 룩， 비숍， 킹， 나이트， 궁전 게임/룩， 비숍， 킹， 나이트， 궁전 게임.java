import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine()), g = 0;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			g^=grundy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken().charAt(0));
		}
		bw.write(g==0?"cubelover":"koosaga");
		bw.flush();
	}
	static int grundy(int a, int b, char ch){
		switch(ch){
			case 'R': return ((a/4)^(b/4))*4+(a^b)%4;
			case 'B': return Math.min(a,b);
			case 'K': return (a%2==b%2)?a%2*2:1+Math.min(a,b)%2*2;
			case 'P': return ((a/3)^(b/3))*3+(a+b)%3;
		}
		//case 'N'
		switch(Math.min(a,b)%3){
			case 1 : if(a!=b) break;
			case 0 : return 0;
			case 2 : if(Math.abs(a-b)>1) return 2;
		}
		return 1;
	}
}