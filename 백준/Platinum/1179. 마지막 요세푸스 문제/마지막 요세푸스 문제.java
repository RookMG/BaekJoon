import java.io.*;
import java.util.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[] arr;
    static long N;
    static int K;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 2; i<K; i++)
            arr[i] = (arr[i-1] + K) % i;
        bw.write(Long.toString(K==1?N:joseph(N) + 1));
        bw.flush();
    }
    static long joseph(long n){
        if(n<K){
            return arr[(int)n];
        }
        long next = joseph(n - (n/K)) - n%K;
        return next<0?next+n:next+next/(K-1);
    }
}