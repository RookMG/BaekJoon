import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		char[] line = br.readLine().toCharArray();
		int answer = 0, r = 0, left = 0, right = line.length-1, lk =0, rk = 0;
		for(char c:line) if(c=='R') r++;
		while(left<=right) {
			if(lk<rk) {
				if(line[left++]=='K') lk++;
				else answer = Math.max(answer, r-- + 2*Math.min(lk, rk));
			}
			else {
				if(line[right--]=='K') rk++;
				else answer = Math.max(answer, r-- + 2*Math.min(lk, rk));
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}