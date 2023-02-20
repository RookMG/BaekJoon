import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), left = 0, right = 0, mid = 0;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			left = Math.max(left, arr[i] = Integer.parseInt(st.nextToken()));
			right+=arr[i];
		}
		while(left<=right) {
			mid = (left+right)/2;
			if(left==right) break;
			int cnt = 1, now = 0;
			for(int i:arr) {
				if(mid<(now+=i)) {
					now = i;
					cnt++;
				}
			}
			if(cnt<=m) right = mid;
			else left = mid+1;
		}
		System.out.println(mid);
	}
}