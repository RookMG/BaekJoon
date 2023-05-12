import java.io.*;
import java.util.*;
public class Main {
    static class Link implements Comparable<Link>{
        int s, e, dist;

        public Link(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }

        @Override
        public int compareTo(Link o) {
            return Integer.compare(o.dist,dist);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] parent;
    static boolean[] visit;
    static int N, M;
    static long answer = 0, max = 0;
    static ArrayList<int[]>[] links;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        visit = new boolean[N+1];
        links = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
            links[i] = new ArrayList<>();
        }
        PriorityQueue<Link> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Link(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int cnt=N-1;cnt>0;){
            Link l = pq.poll();
            int ap = findP(l.s), bp = findP(l.e);
            if(ap==bp) continue;
            cnt--;
            answer += l.dist;
            links[l.s].add(new int[]{l.e,l.dist});
            links[l.e].add(new int[]{l.s,l.dist});
            parent[ap] = bp;
        }
        int start = Integer.parseInt(br.readLine());
        visit[start] = true;
        dfs(start, 0);
        bw.write(Long.toString(2*answer-max));
        bw.flush();
    }
    static void dfs(int node, long val){
        boolean end = true;
        for(int[] next :links[node]){
            if(visit[next[0]]) continue;
            visit[next[0]] = true;
            end = false;
            dfs(next[0],val+next[1]);
        }
        if(end) max = Math.max(max,val);
    }
    static int findP(int n){
        return parent[n] = n==parent[n]?n:findP(parent[n]);
    }
}