import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		long answer = 0;
		int[] arr = new int[n], count = new int[m];
		st = new StringTokenizer(br.readLine());
		if((arr[0] = Integer.parseInt(st.nextToken()) % m)== 0) answer++;
		count[arr[0]]++;
		for(int i=1;i<n;i++) {
			int now = arr[i] = (arr[i-1]+Integer.parseInt(st.nextToken())%m)%m;
			if(now==0) answer+=++count[now];
			else answer+=(count[now]++);
		}
		bw.write(Long.toString(answer));
		bw.flush();
	}
}