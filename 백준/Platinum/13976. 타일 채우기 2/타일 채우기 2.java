import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        long N = Long.parseLong(br.readLine());
        if(N%2==1) bw.write('0');
        else if(N==2) bw.write('3');
        else{
            long[][] ans = matPow(new long[][] {{4,MOD-1},{1,0}},(N-2)>>1);
            bw.write(Long.toString((ans[0][0]*3+ans[0][1])%MOD));
        }
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