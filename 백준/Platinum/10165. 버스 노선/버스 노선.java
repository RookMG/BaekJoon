import java.io.*;
import java.util.*;
public class Main {
    static class Bus implements Comparable<Bus>{
        int start, end, idx;
        public Bus(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
        @Override
        public int compareTo(Bus o) {
            return start==o.start?Integer.compare(o.end,end):Integer.compare(start,o.start);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        boolean[] ans = new boolean[M+1];
        ArrayList<Bus> list = new ArrayList<>();
        for(int i=1, s, e;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            if(s>e) list.add(new Bus(s,e+N,i));
            else{
                list.add(new Bus(s,e,i));
                list.add(new Bus(s+N,e+N,i));
            }
        }
        Collections.sort(list);
        int l = 0, r = 0;
        for(Bus b:list){
            if(l<=b.start&&b.end<=r){
                ans[b.idx] = true;
                continue;
            }
            l = b.start;
            r = b.end;
        }
        for(int i=1;i<=M;i++){
            if(ans[i]) continue;
            sb.append(i).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}