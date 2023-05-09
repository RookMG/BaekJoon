import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        long[] dist = new long[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(dist,10000000000L);
        ArrayList<int[]>[] links = new ArrayList[N+1];
        for(int i=0;i<=N;i++) links[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
            links[b].add(new int[]{a,l});
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Long.compare(dist[o1],dist[o2]);
            }
        });
        st = new StringTokenizer(br.readLine());
        for(int i=0,now;i<K;i++){
            now = Integer.parseInt(st.nextToken());
            pq.add(now);
            dist[now] = 0;
        }
        int[] next;
        while(!pq.isEmpty()){
            int now = pq.poll();
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
        int idx = -1;
        long answer = 0L;
        for(int i=1;i<=N;i++){
            if(dist[i]>answer){
                idx = i;
                answer = dist[i];
            }
        }

        bw.write(Integer.toString(idx));
        bw.write('\n');
        bw.write(Long.toString(answer));
        bw.flush();
    }
}