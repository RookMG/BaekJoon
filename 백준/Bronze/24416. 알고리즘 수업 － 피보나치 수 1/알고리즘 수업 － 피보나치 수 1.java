import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] mat = {{1,1},{1,0}};
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        bw.write(String.format("%d %d",matPow(mat,N-1)[0][0],N-2));
        bw.flush();
    }
    static int[][] matMul(int[][] a, int[][] b){
        int[][] c = new int[b[0].length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                for(int k=0;k<b[0].length;k++){
                    c[i][k] = (c[i][k]+(a[i][j]*b[j][k]));
                }
            }
        }
        return c;
    }
    static int[][] matPow(int[][] a, int num){
        if(num==1) return a;
        else if(num%2==1) return matMul(matPow(a,num-1),a);
        else return matPow(matMul(a,a),num/2);
    }
}