import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int idx;
        ArrayList<int[]> link;
        Node(int idx){
            this.idx = idx;
            link = new ArrayList<>();
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        Node[] nodes = new Node[N+1];
        boolean[] visit = new boolean[N+1];
        for(int i=1;i<=N;i++) nodes[i] = new Node(i);
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b;
            while((b = Integer.parseInt(st.nextToken()))!=-1) nodes[a].link.add(new int[]{b, Integer.parseInt(st.nextToken())});
        }
        dq.offer(new int[]{1,0});
        visit[1] = true;
        int far = 0, dist = 0;
        while(!dq.isEmpty()){
            int[] now = dq.pollFirst();
            if(dist<now[1]){
                far = now[0];
                dist = now[1];
            }
            for(int[] next:nodes[now[0]].link){
                if(visit[next[0]]) continue;
                visit[next[0]] = true;
                dq.offerLast(new int[]{next[0],now[1]+next[1]});
            }
        }
        Arrays.fill(visit,false);
        if(N!=1) dq.offerLast(new int[]{far,0});
        visit[far] = true;
        while(!dq.isEmpty()){
            int[] now = dq.pollFirst();
            dist = Math.max(dist, now[1]);
            for(int[] next:nodes[now[0]].link){
                if(visit[next[0]]) continue;
                visit[next[0]] = true;
                dq.offerLast(new int[]{next[0],now[1]+next[1]});
            }
        }
        bw.write(Integer.toString(dist));
        bw.flush();
    }
}