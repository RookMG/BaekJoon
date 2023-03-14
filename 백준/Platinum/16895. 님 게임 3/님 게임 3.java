import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine()), g = 0, answer = 0;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) g^=arr[i]=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++){
			for(int j=1;j<=arr[i];j++){
				if(((g^arr[i])^(arr[i]-j))==0) answer++;
			}
		}
		bw.write(Integer.toString(answer));
		bw.flush();
	}
}