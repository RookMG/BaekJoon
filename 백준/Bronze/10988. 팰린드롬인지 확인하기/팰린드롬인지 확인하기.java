import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		char[] word = br.readLine().toCharArray();
		char answer = '1';
		for(int l=0,r=word.length-1;l<r;) if(word[l++]!=word[r--]){
			answer = '0'; break;
		}
		bw.write(answer);
		bw.flush();
	}
}