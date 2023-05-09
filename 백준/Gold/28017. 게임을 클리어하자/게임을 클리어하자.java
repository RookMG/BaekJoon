import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), answer = Integer.MAX_VALUE;
        int[] dp = new int[M];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[0],o2[0]));
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            pq.clear();
            for(int j=0;j<M;j++){
                pq.add(new int[]{dp[j],j});
            }
            int[] best = pq.poll();
            for(int j=0;j<M;j++){
                dp[j] = Integer.parseInt(st.nextToken())+(best[1]==j?pq.peek()[0]:best[0]);
            }
        }
        for(int i=0;i<M;i++) answer = Math.min(answer,dp[i]);
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}