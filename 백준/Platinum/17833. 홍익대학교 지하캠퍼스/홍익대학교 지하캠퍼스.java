import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] links = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            links[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            for (int j = N- h; j >=0 ; j--) {
                links[a+j].add(new int[] {b+j,t});
                links[b+j].add(new int[] {a+j,t});
            }
        }

        long[] dist = new long[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(dist,10000000000L);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Long.compare(dist[o1],dist[o2]);
            }
        });
        dist[start] = 0;
        int[] next;
        pq.add(start);
        while(!pq.isEmpty()){
            int now = pq.poll();
            if(now==end) break;
            if(visit[now]) continue;
            visit[now] = true;
            for(int i=links[now].size()-1;i>=0;i--){
                next = links[now].get(i);
                if(!visit[next[0]]&&next[1]+dist[now]<dist[next[0]]){
                    dist[next[0]] = next[1]+dist[now];
                    pq.add(next[0]);
                }
            }
        }
        bw.write(Long.toString(dist[end]==10000000000L?-1:dist[end]));
        bw.flush();
    }
}