import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] alp = new int[26];
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), answer = 0;
		for(int i=0;i<n;i++){
			char[] word = br.readLine().toCharArray();
			for(int j=word.length-1, mul = 1;j>=0;j--, mul*=10) alp[word[j]-'A']-=mul;
		}
		Arrays.sort(alp);
		for(int i=0;i<9;i++) answer -= alp[i]*(9-i);
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}