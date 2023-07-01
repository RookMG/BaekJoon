import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final long MOD = 1000000007L;
    static long[][] loop, ans;
    static long[][][] links;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        links = new long[T][N][N];
        for(int i=0;i<T;i++){
            for(int M = Integer.parseInt(br.readLine());M>0;M--){
                st = new StringTokenizer(br.readLine());
                links[i][Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
            }
        }
        loop = links[0];
        for(int i=1;i<T;i++) loop = matMul(loop,links[i]);
        if(D/T!=0) {
            ans = matPow(loop, D / T);
            for (int i = 1; i <= D % T; i++) ans = matMul(ans, links[i - 1]);
        }else{
            ans = D==0?new long[N][N]:links[0];
            for (int i = 2; i <= D % T; i++) ans = matMul(ans, links[i - 1]);
        }
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++) sb.append(ans[r][c]).append(' ');
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
}