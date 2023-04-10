import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		int[] data = new int[n], count = new int[d+1];
		count[c]++;
		for(int i=0;i<n;i++) data[i] = Integer.parseInt(br.readLine());
		int now = 1, max;
		for(int i=0;i<k;i++) if(count[data[i]]++==0) now++;
		max = now;
		for(int i=k;i<n;i++){
			if(--count[data[i-k]]==0) now--;
			if(count[data[i]]++==0) {
				now++;
				max = Math.max(max, now);
			}
		}
		for(int i=0;i<k;i++){
			if(--count[data[n+i-k]]==0) now--;
			if(count[data[i]]++==0) {
				now++;
				max = Math.max(max, now);
			}
		}
		bw.write(Integer.toString(max));
		bw.flush();
	}
}