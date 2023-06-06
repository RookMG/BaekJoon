import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        PriorityQueue<int[]> stops = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0],o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            stops.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken()), fuel = Integer.parseInt(st.nextToken());
        for(;fuel<goal;ans++,fuel-=pq.poll()){
            while(!stops.isEmpty()&&stops.peek()[0]<=fuel) pq.add(-stops.poll()[1]);
            if(pq.isEmpty()){
                ans = -1;
                break;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}