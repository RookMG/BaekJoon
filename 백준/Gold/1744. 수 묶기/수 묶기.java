import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), answer = 0;
		ArrayList<Integer> a1 = new ArrayList<>(), a2 = new ArrayList<>();
		for(int i=0;i<n;i++){
			int num = Integer.parseInt(br.readLine());
			if(num>1) a1.add(num);
			else if(num<1) a2.add(num);
			else answer++;
		}
		Collections.sort(a1,Collections.reverseOrder());
		Collections.sort(a2);
		for(int i=1;i<a1.size();i+=2) answer += a1.get(i)*a1.get(i-1);
		for(int i=1;i<a2.size();i+=2) answer += a2.get(i)*a2.get(i-1);
		if(a1.size()%2==1) answer += a1.get(a1.size()-1);
		if(a2.size()%2==1) answer += a2.get(a2.size()-1);
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}