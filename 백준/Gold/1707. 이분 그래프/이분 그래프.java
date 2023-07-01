import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int test = Integer.parseInt(br.readLine());test>0;test--) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[] visit = new int[N + 1];
            boolean answer = true;
            ArrayList<Integer>[] links = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) links[i] = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
                links[a].add(b);
                links[b].add(a);
            }
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            bfs:
            for(int cnt = N;cnt>0;cnt--) {
                dq.clear();
                for(int i=1;i<=N;i++){
                    if(visit[i]!=0) continue;
                    visit[i] = 1;
                    dq.add(i);
                    break;
                }
                while (!dq.isEmpty()) {
                    int now = dq.pollFirst();
                    for (int next : links[now]) {
                        if (visit[next] == visit[now]) {
                            answer = false;
                            break bfs;
                        }
                        if (visit[next] == 0) {
                            visit[next] = 3 - visit[now];
                            dq.offerLast(next);
                        }
                    }
                }
            }
            sb.append(answer?"YES\n":"NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}