import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n], tmp;
		for(int i=1;i<=n;i++) arr[i-1] = i;
		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			tmp = Arrays.copyOf(arr,n);
			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), mid = Integer.parseInt(st.nextToken());
			for(int j=0;j<=e-s;j++) arr[s-1+j] = tmp[s-1+(mid+j-s)%(e-s+1)];
		}
		for(int i=0;i<n;i++){
			bw.write(Integer.toString(arr[i]));
			bw.write(" ");
		}
		bw.flush();
	}
}