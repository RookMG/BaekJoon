import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = 1000000007L;
    static long[][] mat;
    public static void main(String[] args) throws Exception {
        mat = new long[8][8];
        mat[0][1] = mat[1][0] = mat[0][4] = mat[4][0] = mat[0][6] = mat[6][0] = mat[1][2] = mat[2][1] = mat[1][6] = mat[6][1] = mat[1][7] = mat[7][1] = mat[2][7] = mat[7][2] = mat[2][3] = mat[3][2] = mat[3][7] = mat[7][3] = mat[4][5] = mat[5][4] = mat[5][6] = mat[6][5] = mat[6][7] = mat[7][6] = 1;
        long N = Long.parseLong(br.readLine());
        bw.write(Long.toString(matPow(mat,N)[3][3]));
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