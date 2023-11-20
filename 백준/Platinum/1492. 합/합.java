import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] dp = new long[K+1], com = new long[K+1];
        dp[0] = N;
        for(int i=0;i<=K;i++) com[i] = i+1;
        for(int i=1;i<=K;i++){
            long psum = N;
            for(int j=i-1;j>0;j--){
                com[j] = (com[j]+com[j-1])%MOD;
                psum = (psum + com[j]*dp[j]%MOD)%MOD;
            }
            dp[i] = pow(com[i],MOD-2)*(MOD+pow(N+1,i+1)-1-psum)%MOD;
        }
        bw.write(Long.toString(dp[K]));
        bw.flush();
    }
    static long pow(long base, long exp){
        if(exp==0) return 1;
        else if(exp == 1) return base;
        long ret = pow(base,exp>>1);
        ret = ret*ret%MOD;
        if((exp&1) == 1) ret = ret*base%MOD;
        return ret;
    }
}