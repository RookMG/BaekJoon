import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringBuffer bf = new StringBuffer();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<String>();
        for(int i=0;i<N;i++) pq.add(br.readLine()+"[");
        while(!pq.isEmpty()){
            bf.setLength(0);
            bf.append(pq.poll());
            sb.append(bf.charAt(0));
            if(bf.length()==2) continue;
            bf.deleteCharAt(0);
            pq.add(bf.toString());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}