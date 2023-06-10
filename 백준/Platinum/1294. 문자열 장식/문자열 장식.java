import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder(), tmp = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<String>();
        for(int i=0;i<N;i++) pq.add(br.readLine()+"[");
        while(!pq.isEmpty()){
            tmp.setLength(0);
            tmp.append(pq.poll());
            sb.append(tmp.charAt(0));
            if(tmp.length()==2) continue;
            tmp.deleteCharAt(0);
            pq.add(tmp.toString());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}