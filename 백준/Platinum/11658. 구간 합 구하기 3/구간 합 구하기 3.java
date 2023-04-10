import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		long[][] fenwick = new long[N+1][N+1], arr = new long[N+1][N+1];
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++){
				arr[i][j] = Long.parseLong(st.nextToken());
				for(int r=i;r<=N;r+=r&-r){
					for(int c=j;c<=N;c+=c&-c){
						fenwick[r][c] += arr[i][j];
					}
				}
			}
		}
		for(int q=0;q<M;q++){
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0){
				int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken());
				long num = Long.parseLong(st.nextToken());
				for(int r=i;r<=N;r+=r&-r){
					for(int c=j;c<=N;c+=c&-c){
						fenwick[r][c] += num-arr[i][j];
					}
				}
				arr[i][j] = num;
			}else{
				int sr = Integer.parseInt(st.nextToken()), sc = Integer.parseInt(st.nextToken()), er = Integer.parseInt(st.nextToken()), ec = Integer.parseInt(st.nextToken());
				long sum = 0;
				for(int r=er;r>0;r-=r&-r){
					for(int c=ec;c>0;c-=c&-c){
						sum += fenwick[r][c];
					}
				}
				for(int r=er;r>0;r-=r&-r){
					for(int c=sc-1;c>0;c-=c&-c){
						sum -= fenwick[r][c];
					}
				}
				for(int r=sr-1;r>0;r-=r&-r){
					for(int c=ec;c>0;c-=c&-c){
						sum -= fenwick[r][c];
					}
				}
				for(int r=sr-1;r>0;r-=r&-r){
					for(int c=sc-1;c>0;c-=c&-c){
						sum += fenwick[r][c];
					}
				}
				sb.append(sum).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}