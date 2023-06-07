import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long N, M, K;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solve();
        bw.write(sb.toString());
        bw.flush();
    }
    static void solve(){
        if(M+K>N+1||N>M*K){
            sb.append("-1");
            return;
        }
        ArrayDeque<Long> sizes = new ArrayDeque<>();
        for(long left = N-M, i=0;i<M;i++){
            sizes.offerFirst(1+Math.min(K-1,left));
            left = Math.max(left-K+1,0);
        }
        for(long i=1, j;!sizes.isEmpty();){
            j = sizes.pollFirst();
            i+=j;
            for(int k=1;k<=j;k++) sb.append(i-k).append(' ');
        }
        sb.append('\n');
        for(long left = N-K, i=0;i<K;i++){
            sizes.offerFirst(1+Math.min(M-1,left));
            left = Math.max(left-M+1,0);
        }
        for(long i=N, j;!sizes.isEmpty();){
            j = sizes.pollFirst();
            i-=j;
            for(int k=1;k<=j;k++) sb.append(i+k).append(' ');
        }
    }
}