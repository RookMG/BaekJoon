import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final long MOD = 1000000007L;
    static long[][] mat;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        mat = new long[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            mat[a][b] = mat[b][a] = 1;
        }
        bw.write(Long.toString(matPow(mat, Integer.parseInt(br.readLine()))[1][1]));
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
}