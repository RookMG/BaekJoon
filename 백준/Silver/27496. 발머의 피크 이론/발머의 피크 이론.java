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
		int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()), answer = 0;
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		arr[0] = Long.parseLong(st.nextToken());
		for(int i=1;i<n;i++){
			arr[i] = arr[i-1]+Long.parseLong(st.nextToken());
		}
		for(int i=0;i<l;i++)
			if(129<=arr[i]&&arr[i]<=138) answer++;
		for(int i=l;i<n;i++){
			long now = arr[i]-arr[i-l];
			if(129<=now&&now<=138) answer++;
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}