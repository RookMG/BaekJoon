import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final long MOD = 1_000_000_009L;
    static final long[][] mat = {{1,1,1},{1,0,0},{0,1,0}};
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) sb.append(matPow(mat, Integer.parseInt(br.readLine()))[0][0]).append('\n');
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
}