import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static long answer;
	static int[] arr, tmp;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine()); answer = 0;
		arr = new int[n]; tmp = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		mergeSort(0,n-1);
		bw.write(Long.toString(answer));
		bw.flush();
	}

	public static void mergeSort(int start, int end) {
		if(start>=end) return;
		int mid = (start+end)/2;
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		int p = start, q = mid + 1, idx = p;
		while (p<=mid || q<=end) {
			if (q>end || (p<=mid && arr[p]<=arr[q])) tmp[idx++] = arr[p++];
			else {
				answer+=1+mid-p;
				tmp[idx++] = arr[q++];
			}
		}
		for (int i=start;i<=end;i++) arr[i]=tmp[i];
	}
}