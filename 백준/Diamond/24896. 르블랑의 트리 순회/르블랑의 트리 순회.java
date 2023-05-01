import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        ArrayList<Node> links;
        int idx;
        Node(int idx){
            this.idx = idx;
            links = new ArrayList<>();
        }
        void remove(){
            if(visit[idx]||links.size()>2) return;
            visit[idx] = true;
            for(Node n:links) n.remove();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Node[] tree;
    static int N;
    static boolean[] visit;
    static int[][] input;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];
        input = new int[N][2];
        for(int i=0;i<=N;i++){
            tree[i] = new Node(i);
        }
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            tree[a].links.add(tree[b]);
            tree[b].links.add(tree[a]);
            input[i][0] = a;
            input[i][1] = b;
        }

        visit = new boolean[N+1];
        for(int level=1;level<=2;level++) {
            for (int i = 1; i <= N; i++) {
                if(tree[i].links.size()!=1) continue;
                tree[i].remove();
            }
            for(Node n: tree) n.links.clear();
            for(int i=1;i<N;i++){
                if(visit[input[i][0]]||visit[input[i][1]]) continue;
                tree[input[i][0]].links.add(tree[input[i][1]]);
                tree[input[i][1]].links.add(tree[input[i][0]]);
            }
        }

        boolean answer = true;
        for(int i=1;i<=N;i++){
            if(tree[i].links.size()>2) {
                answer = false;
                break;
            }
        }
        bw.write(answer?"YES":"NO");
        bw.flush();
    }
}