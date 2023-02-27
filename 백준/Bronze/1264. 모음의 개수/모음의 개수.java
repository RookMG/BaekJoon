import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		while(true){
			char[] line = br.readLine().toCharArray();
			if(line.length==1&&line[0]=='#') break;
			int answer = 0;
			for(char ch:line) if("AEIOUaeiou".indexOf(ch)>=0) answer++;
			bw.write(Integer.toString(answer));
			bw.write("\n");
		}
		bw.flush();
	}
}