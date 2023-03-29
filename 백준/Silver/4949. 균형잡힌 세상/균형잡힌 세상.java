import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		boolean valid;
		char[] line;
		ArrayDeque<Character> s;
		while(true){
			valid = true;
			line = br.readLine().toCharArray();
			if(line.length==1&&line[0]=='.') break;
			s = new ArrayDeque<>();
			for(char ch:line){
				if("([".indexOf(ch)>=0) s.offerLast(ch);
				else if(")]".indexOf(ch)>=0){
					if(s.isEmpty()||"([".indexOf(s.pollLast())!=")]".indexOf(ch)){
						valid = false;
						break;
					}
				}
			}
			if(!s.isEmpty()) valid = false;
			bw.write(valid?"yes\n":"no\n");
		}
		bw.flush();
	}
}