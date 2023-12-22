import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int idx, go, back;
        ArrayList<int[]> forward, reverse;
        Node(int idx){
            this.idx = idx;
            go = Integer.MAX_VALUE;
            back = Integer.MAX_VALUE;
            forward = new ArrayList<>();
            reverse = new ArrayList<>();
        }
        public Node update(int cost, boolean back){
            if(back) this.back = cost;
            else this.go = cost;
            return this;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken()), ans = 0;
        Node[] nodes = new Node[N+1];
        for(int i=1;i<=N;i++) nodes[i] = new Node(i);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            nodes[a].forward.add(new int[]{b, c});
            nodes[b].reverse.add(new int[]{a, c});
        }
        nodes[X].go = nodes[X].back = 0;
        boolean[] visit = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.back));
        pq.offer(nodes[X]);
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visit[now.idx]) continue;
            visit[now.idx] = true;
            for(int[] next:now.forward){
                if(nodes[next[0]].back <= now.back +next[1]) continue;
                pq.offer(nodes[next[0]].update(now.back + next[1], true));
            }
        }
        visit = new boolean[N+1];
        pq = new PriorityQueue<>(Comparator.comparingInt(o->o.go));
        pq.offer(nodes[X]);
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visit[now.idx]) continue;
            visit[now.idx] = true;
            for(int[] next:now.reverse){
                if(nodes[next[0]].go <= now.go +next[1]) continue;
                pq.offer(nodes[next[0]].update(now.go + next[1], false));
            }
        }
        for(int i=1;i<=N;i++) ans = Math.max(ans,nodes[i].go+nodes[i].back);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}