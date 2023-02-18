import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int answer = 1;
        char[] word = br.readLine().toCharArray();
        for(int i=1;i<word.length;i++) if(word[i-1]>=word[i]) answer++;
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}