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
		int n = Integer.parseInt(st.nextToken()) , m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i>0) arr[i][j]+=arr[i-1][j];
				if(j>0) arr[i][j]+=arr[i][j-1];
				if(i>0&&j>0) arr[i][j]-=arr[i-1][j-1];
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++){
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1, c1 = Integer.parseInt(st.nextToken())-1, r2 = Integer.parseInt(st.nextToken())-1, c2 = Integer.parseInt(st.nextToken())-1, sum = arr[r2][c2];
			if(r1>0) sum-=arr[r1-1][c2];
			if(c1>0) sum-=arr[r2][c1-1];
			if(r1>0&&c1>0) sum+=arr[r1-1][c1-1];
			bw.write(Integer.toString(sum));
			bw.write("\n");
		}
		bw.flush();
	}
}