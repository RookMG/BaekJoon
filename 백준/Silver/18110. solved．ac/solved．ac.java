import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), outs = Math.round(0.15f*N), sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) pq.add(Integer.parseInt(br.readLine()));
        for(int i=0;i<outs;i++) pq.poll();
        for(int i=outs;i<N-outs;i++) sum+=pq.poll();
        bw.write(Integer.toString(Math.round(1.0f*sum/(N-outs*2))));
        bw.flush();
    }
}