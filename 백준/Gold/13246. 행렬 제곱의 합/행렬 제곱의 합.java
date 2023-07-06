import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final long MOD = 1000L;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long[][] arr = new long[N][N], pow;
		for(int r=0;r<N;r++){
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) arr[r][c] = Long.parseLong(st.nextToken());
		}
		pow = customPow(arr,B);
		for(int r=0;r<N;r++){
			for(int c=0;c<N;c++) sb.append(pow[r][c]%MOD).append(' ');
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static long[][] matMul(long[][] a, long[][] b){
		long[][] c = new long[b[0].length][a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				for(int k=0;k<b[0].length;k++){
					c[i][k] = (c[i][k]+(a[i][j]*b[j][k])%MOD)%MOD;
				}
			}
		}
		return c;
	}
	static long[][] matPow(long[][] a, long num){
		if(num==1) return a;
		else if(num%2==1) return matMul(matPow(a,num-1),a);
		else return matPow(matMul(a,a),num/2);
	}
	static long[][] matSum(long[][] a, long[][] b){
		long[][] ret = new long[a.length][a[0].length];
		for(int r=0;r<a.length;r++){
			for(int c=0;c<a[0].length;c++) ret[r][c] = a[r][c] + b[r][c];
		}
		return ret;
	}
	static long[][] customPow(long[][] a, long num){
		if(num==1) return a;
		if(num%2==1) return matSum(customPow(a,num-1),matPow(a,num));
		long[][] ia = new long[a.length][a[0].length], pow = matPow(a,num>>1);
		for(int r=0;r<a.length;r++){
			for(int c=0;c<a[0].length;c++) ia[r][c] = pow[r][c] + (r==c?1:0);
		}
		return matMul(customPow(a,num>>1),ia);
	}
}