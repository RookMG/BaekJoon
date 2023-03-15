import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		Deque<Character> s = new ArrayDeque<>(), tmp;
		char[] line = br.readLine().toCharArray(), key = br.readLine().toCharArray();
		for(char ch : line) {
			s.offerLast(ch);
			if(ch==key[key.length-1]&&s.size()>=key.length){
				tmp = new ArrayDeque<>();
				for(int i=0;i<key.length;i++){
					char n = s.pollLast();
					if(n!=key[key.length-1-i]){
						s.offerLast(n);
						while(!tmp.isEmpty()) s.offerLast(tmp.pollLast());
					}else{
						tmp.offerLast(n);
					}
				}
			}
		}
		if(s.isEmpty()) bw.write("FRULA");
		else while(!s.isEmpty()) bw.write(s.pollFirst());
		bw.flush();
	}
}