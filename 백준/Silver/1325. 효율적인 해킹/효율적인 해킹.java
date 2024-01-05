import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer>[] link;
    static boolean[] visit;
    static int[] cnt;
    static int idx;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), max = -1;
        link = new ArrayList[N+1];
        cnt = new int[N+1];
        for(int i=1;i<=N;i++) link[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            link[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        for(idx=1;idx<=N;idx++){
            visit = new boolean[N+1];
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.offerLast(idx);
            visit[idx] = true;
            while (!dq.isEmpty()) {
                int now = dq.pollFirst();
                for (int next : link[now]) {
                    if(visit[next]) continue;
                    visit[next] = true;
                    cnt[next]++;
                    dq.offerLast(next);
                }
            }
        }
        for(idx=1;idx<=N;idx++) max = Math.max(max,cnt[idx]);
        for(idx=1;idx<=N;idx++){
            if(cnt[idx]!=max) continue;
            sb.append(idx).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}