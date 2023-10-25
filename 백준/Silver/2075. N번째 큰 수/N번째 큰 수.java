import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int c=0;c<N;c++) pq.offer(Integer.parseInt(st.nextToken()));
        ans = pq.peek();
        for(int r=1;r<N;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++){
                int num = Integer.parseInt(st.nextToken());
                if(ans>num) continue;
                pq.poll();
                pq.offer(num);
                ans = pq.peek();
            }
        }
        bw.write((Integer.toString(ans)));
        bw.flush();
    }
}