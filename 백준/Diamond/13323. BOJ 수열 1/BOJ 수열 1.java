// https://velog.io/@idwooin/Slope-Trick
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long ans = 0L;
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0, now;i<N;i++,pq.offer(now)){
            now = i - Integer.parseInt(st.nextToken());
            if(pq.isEmpty()||pq.peek()>=now) continue;
            pq.offer(now);
            ans += now - pq.poll();
        }
        bw.write(Long.toString(ans));
        bw.flush();
    }
}