import java.io.*;
import java.util.*;
public class Main {
    static class Link{
        int end, time, interval;
        public Link(int end, int time, int interval) {
            this.end = end;
            this.time = time;
            this.interval = interval;
        }
    }
    static class Node implements Comparable<Node>{
        int time, k, idx;
        public Node(int time, int k, int idx) {
            this.time = time;
            this.k = k;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(time,o.time);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), ans = -1;
        ArrayList<Link>[] links = new ArrayList[N+1];
        for(int i=1;i<=N;i++) links[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            links[Integer.parseInt(st.nextToken())].add(new Link(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Link l:links[1]) pq.offer(new Node(l.time,0,l.end));
        int[] visit = new int[N+1];
        Arrays.fill(visit,K+1);
        for(;!pq.isEmpty();){
            Node now = pq.poll();
            if(visit[now.idx]<=now.k) continue;
            visit[now.idx] = now.k;
            if(now.idx==N){
                ans = now.time;
                break;
            }
            for(Link l:links[now.idx]){
                if(now.k<K&&now.time%l.interval!=0&&visit[l.end]>=now.k+1) pq.offer(new Node(now.time+l.time,now.k+1,l.end));
                if(visit[l.end]>=now.k) pq.offer(new Node(now.time+l.time+(now.time%l.interval==0?0:l.interval-now.time%l.interval),now.k,l.end));
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}