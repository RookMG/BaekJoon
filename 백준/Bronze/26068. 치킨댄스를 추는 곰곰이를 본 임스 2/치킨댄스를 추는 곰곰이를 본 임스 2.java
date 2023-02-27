import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), answer = 0;
		for(int i=0;i<n;i++) if(Integer.parseInt(br.readLine().substring(2))<=90) answer++;
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}