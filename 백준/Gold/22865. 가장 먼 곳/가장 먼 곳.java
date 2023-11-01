import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1],o2[1]);
            }
        });
        ArrayList<ArrayList<int[]>> links = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        long[] cost = new long[N+1];
        Arrays.fill(cost,Integer.MAX_VALUE/2);
        for(int i=0;i<=N;i++) links.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++){
            int start = Integer.parseInt(st.nextToken());
            pq.offer(new long[]{start,0});
            cost[start] = 0;
        }
        for(int i = Integer.parseInt(br.readLine());i>0;i--){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            links.get(a).add(new int[] {b,d});
            links.get(b).add(new int[] {a,d});
        }
        while(!pq.isEmpty()){
            long[] now = pq.poll();
            if(cost[(int)now[0]]<now[1]) continue;
            for(int[] next: links.get((int)now[0])){
                if(cost[next[0]]<=now[1]+next[1]) continue;
                cost[next[0]] = now[1]+next[1];
                pq.offer(new long[]{next[0],cost[next[0]]});
            }
        }
        int ans = 0;
        long dist = 0;
        for(int i=1;i<=N;i++){
            if(cost[i]<=dist) continue;
            dist = cost[i];
            ans = i;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}