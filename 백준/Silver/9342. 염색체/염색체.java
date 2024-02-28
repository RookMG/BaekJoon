import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		String reg = "[A-F]?A+F+C+[A-F]?";
		for(int i=0;i<n;i++) sb.append(Pattern.matches(reg,br.readLine())?"Infected!\n":"Good\n");
		bw.write(sb.toString());
		bw.flush();
	}
}