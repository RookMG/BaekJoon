import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = 10007;
    static long[][] mat = new long[10][10];
    public static void main(String[] args) throws Exception {
        for(int r=0;r<10;r++){
            for(int c=0;c<10;c++){
                if(r>c) continue;
                mat[r][c] = 1;
            }
        }
        int N = Integer.parseInt(br.readLine());
        bw.write(String.format("%d",matPow(mat,N+1)[0][9]));
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