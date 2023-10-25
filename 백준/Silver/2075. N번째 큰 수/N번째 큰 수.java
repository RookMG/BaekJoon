import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int c=0;c<N;c++) pq.offer(Integer.parseInt(st.nextToken()));
        for(int r=1;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                int num = Integer.parseInt(st.nextToken());
                if(pq.peek()>num) continue;
                pq.poll();
                pq.offer(num);
            }
        }
        bw.write((Integer.toString(pq.poll())));
        bw.flush();
    }
}