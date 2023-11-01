import java.io.*;
import java.util.*;
public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        long dist;

        public Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(dist,o.dist);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<ArrayList<int[]>> links = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        for(int i=0;i<=N;i++) links.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++){
            int start = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, 0));
            dist[start] = 0;
        }
        for(int i = Integer.parseInt(br.readLine());i>0;i--){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            links.get(a).add(new int[] {b,d});
            links.get(b).add(new int[] {a,d});
        }
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.idx]<now.dist) continue;
            for(int[] next: links.get(now.idx)){
                if(dist[next[0]]<=now.dist+next[1]) continue;
                pq.offer(new Node(next[0],dist[next[0]] = now.dist+next[1]));
            }
        }
        int ans = 0;
        long longest = 0;
        for(int i=1;i<=N;i++){
            if(dist[i]<=longest) continue;
            longest = dist[i];
            ans = i;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}