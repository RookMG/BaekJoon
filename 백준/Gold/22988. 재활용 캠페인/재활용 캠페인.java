import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken()), answer = 0, fail = 0;
		long[] bottle = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			bottle[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(bottle);
		int left = 0, right = n-1;
		for(int i=n-1;i>=0;i--) {
			if(bottle[i]!=x) break;
			answer++;
			right--;
		}
		while(left<=right) {
			if(left<right&&(bottle[left]+bottle[right])*2>=x) {
				left++;
				right--;
				answer++;
			}else {
				left++;
				fail++;
			}
		}
		bw.write(Long.toString(answer+fail/3));
		bw.flush();
	}
}