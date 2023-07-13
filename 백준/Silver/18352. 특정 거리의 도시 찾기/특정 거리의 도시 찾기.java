import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N+1];
        ArrayList<ArrayList<Integer>> links = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<=N;i++) links.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            links.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        visit[X] = true;
        dq.offerLast(X);
        for(int i=0;i<K&&!dq.isEmpty();i++){
            for(int s = dq.size();s>0;s--){
                int now = dq.pollFirst();
                for(int next:links.get(now)){
                    if(visit[next]) continue;
                    visit[next] = true;
                    dq.offerLast(next);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(dq);
        if(dq.isEmpty()) sb.append("-1");
        while(!pq.isEmpty()) sb.append(pq.poll()).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}