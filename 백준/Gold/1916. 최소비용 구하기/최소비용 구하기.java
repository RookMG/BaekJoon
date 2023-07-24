import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int V = Integer.parseInt(br.readLine()), E = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> links = new ArrayList<>();
        for(int i=0;i<=V;i++) links.add(new ArrayList<>());
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
            links.get(from).add(new int[]{to,weight});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int[] cost = new int[V+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        pq.offer(new int[]{start,0});
        int[] now, next;
        while(!pq.isEmpty()){
            now = pq.poll();
            if(cost[now[0]]<now[1]) continue;
            for(int i=links.get(now[0]).size()-1;i>=0;i--){
                next = links.get(now[0]).get(i);
                if(cost[next[0]]>now[1]+next[1]) pq.offer(new int[]{next[0], cost[next[0]] = now[1]+next[1]});
            }
        }
        bw.write(Integer.toString(cost[end]));
        bw.flush();
    }
}