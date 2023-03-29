import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K, M;
    static boolean[] prime;
    static int[] cntPrime;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prime = new boolean[N+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        cntPrime = new int[N+1];
        getPrime();
        count();
        long answer = 1L;
        for(int i=1;i<=N;i++){
            for(int j=0;j<cntPrime[i];j++){
                answer*=i;
                answer%=M;
            }
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
    static void getPrime(){
        for(int i=2;i<=Math.sqrt(N);i++){
            if(!prime[i]) continue;
            for(int j=i*2;j<=N;j+=i){
                prime[j]=false;
            }
        }
    }
    static void count(){
        for(int i=2;i<=N;i++){
            if(!prime[i]) continue;
            for(long j=i;j<=N;j*=i){
                cntPrime[i] += (N/j)-(K/j)-((N-K)/j);
            }
        }
    }
}