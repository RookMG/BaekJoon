import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i= Integer.parseInt(br.readLine());i>0;i--) pq.add(Integer.parseInt(br.readLine()));
        while (!pq.isEmpty()) sb.append(pq.poll()).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}