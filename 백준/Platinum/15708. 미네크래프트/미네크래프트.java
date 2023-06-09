import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken()), ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0, now, sum = 0, cnt = 1; i < N; i++, cnt++) {
            sum += now = Integer.parseInt(st.nextToken());
            pq.add(-now);
            while (cnt > 0 && (long) sum + (long) P * i > T) {
                if (T >= (long) P * i) {
                    cnt--;
                    sum += pq.poll();
                    continue;
                }
                sum = cnt = 0;
                break;
            }
            ans = Math.max(ans, cnt);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}