import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        ArrayList<int[]> child;
        boolean visit;
        Node(){
            child = new ArrayList<>();
            visit = false;
        }
        void dfs(int cost){
            visit = true;
            int cnt = 0;
            for(int[] next:child){
                if(nodes[next[0]].visit) continue;
                cnt++;
                nodes[next[0]].dfs(cost+next[1]);
            }
            branch = Math.max(branch, cost);
            if(cnt!=1) pole = cost;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Node[] nodes;
    static int pole = 0, branch = 0;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
        nodes = new Node[N+1];
        for(int i=1;i<=N;i++) nodes[i] = new Node();
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            nodes[a].child.add(new int[]{b, d});
            nodes[b].child.add(new int[]{a, d});
        }
        nodes[R].dfs(0);
        sb.append(pole).append(' ').append(branch-pole);
        bw.write(sb.toString());
        bw.flush();
    }
}