import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[] sum;
    static long[][] dp;
    static int[][] c, dist;
    static int N, B, S, R;
    static ArrayList<int[]>[] forward, backward;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
        sum = new long[B+1];
        dp = new long[S+1][B+1];
        c = new int[S+1][B+1];
        dist = new int[3][N+1];
        Arrays.fill(dist[1],1_000_000_000);
        Arrays.fill(dist[2],1_000_000_000);
        dist[1][B+1] = dist[2][B+1] = 0;
        forward = new ArrayList[N+1];
        backward = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }
        for(int i=0, a, b, c;i<R;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
            forward[a].add(new int[]{b,c});
            backward[b].add(new int[]{a,c});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        pq.offer(new int[]{B+1,0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[1]>dist[1][now[0]]) continue;
            for(int[] next:forward[now[0]]){
                if(now[1]+next[1] >= dist[1][next[0]]) continue;
                dist[1][next[0]] = now[1]+next[1];
                pq.offer(new int[]{next[0], dist[1][next[0]] = now[1]+next[1]});
            }
        }
        pq.clear();
        pq.offer(new int[]{B+1,0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[1]>dist[2][now[0]]) continue;
            for(int[] next:backward[now[0]]){
                if(now[1]+next[1] >= dist[2][next[0]]) continue;
                dist[2][next[0]] = now[1]+next[1];
                pq.offer(new int[]{next[0], dist[2][next[0]] = now[1]+next[1]});
            }
        }
        for(int i=1;i<=B;i++) dist[0][i] = dist[1][i]+dist[2][i];
        Arrays.sort(dist[0],1,B+1);
        for(int i=1;i<=B;i++){
            dp[1][i] = (sum[i] += sum[i-1]+dist[0][i])*(i-1);
            c[1][i] = 1;
        }
        for(int i=2;i<=S;i++) recur(i,i,B,0,B);
        bw.write(Long.toString(dp[S][B]));
        bw.flush();
    }
    static void recur(int idx, int l, int r, int cl, int cr){
        if(l > r) return;
        int m = (l + r) >> 1;
        dp[idx][m] = c[idx][m] = -1;
        long tmp;
        for(int i=cl; i<=Math.min(m-1,cr); i++){
            tmp = dp[idx-1][i] + (sum[m]-sum[i])*(m-i-1);
            if(dp[idx][m]!=-1&&dp[idx][m]<=tmp) continue;
            dp[idx][m] = tmp;
            c[idx][m] = i;
        }
        recur(idx, l, m-1, cl, c[idx][m]);
        recur(idx, m+1, r, c[idx][m], cr);
    }
}