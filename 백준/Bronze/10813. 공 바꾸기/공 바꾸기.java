import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++) arr[i] = i;
		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
		}
		for(int i=1;i<=n;i++) {
			bw.write(Integer.toString(arr[i]));
			bw.write(" ");
		}
		bw.flush();
	}
}