import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MOD = 9901;
    static int[][] mat = {{1,1,1},{1,0,1},{1,1,0}};
    public static void main(String[] args) throws Exception {
        int answer = matPow(mat,1+Integer.parseInt(br.readLine()))[0][0];
        bw.write(Integer.toString(answer%MOD));
        bw.flush();
    }
    static int[][] matMul(int[][] a, int[][] b){
        int[][] c = new int[b[0].length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                for(int k=0;k<b[0].length;k++){
                    c[i][k] = (c[i][k]+(a[i][j]*b[j][k])%MOD)%MOD;
                }
            }
        }
        return c;
    }
    static int[][] matPow(int[][] a, int num){
        if(num==1) return a;
        return num%2==1?matMul(matPow(a,num-1),a):matPow(matMul(a,a),num/2);
    }
}