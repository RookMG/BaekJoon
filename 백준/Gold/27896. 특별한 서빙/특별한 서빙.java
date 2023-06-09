import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        long score=0, answer=0;
        for(long i=0, now;i<N;i++){
            now = Long.parseLong(st.nextToken());
            pq.add(-2*now);
            score += now;
            if(score<M) continue;
            score += pq.poll();
            answer++;
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
}