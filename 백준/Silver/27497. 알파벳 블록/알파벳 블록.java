import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder(), lb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), idx = 0;
		boolean[] left = new boolean[n];
		char[] ch = new char[n];
		for(int i=0;i<n;i++){
			String line = br.readLine();
			if(line.charAt(0)=='3'){
				idx = Math.max(--idx,0);
			}else{
				left[idx] = line.charAt(0)=='2';
				ch[idx++] = line.charAt(2);
			}
		}
		if(idx==0){
			bw.write("0");
			bw.flush();
			return;
		}
		for(int i=0;i<idx;i++){
			if(left[i]) lb.append(ch[i]);
			else sb.append(ch[i]);
		}
		lb.reverse();
		bw.write(lb.toString());
		bw.write(sb.toString());
		bw.flush();
	}
}