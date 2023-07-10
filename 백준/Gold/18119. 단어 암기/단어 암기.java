import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] dict = new int[N];
		char[] line;
		for(int i=0,mask=0;i<N;i++,mask=0){
			line = br.readLine().toCharArray();
			for(int j=line.length-1;j>=0;j--) mask|=(1<<(line[j]-'A'));
			dict[i] = mask;
		}
		for(int i=0, know = (1<<27)-1, answer;i<M;i++){
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			know^=(1<<(st.nextToken().charAt(0)-'A'));
			answer = 0;
			for(int j=0;j<N;j++){
				if(dict[j]==(dict[j]&know)) answer++;
			}
			sb.append(answer).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
}