import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        long[] dp = new long[K+1], com = new long[K+1];
        long psum = dp[0] = N;
        for(int i=0;i<=K;i++) com[i] = i+1;
        for(int i=1;i<=K;i++,psum = N){
            for(int j=i-1;j>0;j--) psum = (psum + (com[j] = (com[j]+com[j-1])%MOD)*dp[j]%MOD)%MOD;
            dp[i] = pow(com[i],MOD-2)*(MOD+pow(N+1,i+1)-1-psum)%MOD;
        }
        bw.write(Long.toString(dp[K]));
        bw.flush();
    }
    static long pow(long base, long exp){
        if(exp<=1) return exp == 1?base:1;
        long ret = pow(base,exp>>1);
        return (exp&1) == 1?ret*ret%MOD*base%MOD:ret*ret%MOD;
    }
}