import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] visit;
    static class Node{
        int idx, in, out;
        ArrayList<Node> childs;
        Node(int idx){
            this.idx = idx;
            in = 1;
            out = 0;
            childs = new ArrayList<>();
        }
        void update(){
            visit[idx] = true;
            for(Node n:childs){
                if(visit[n.idx]) continue;
                n.update();
                out += n.in;
                in += Math.min(n.out,n.in);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            nodes[i] = new Node(i);
        }
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            nodes[a].childs.add(nodes[b]);
            nodes[b].childs.add(nodes[a]);
        }
        nodes[1].update();
        bw.write(Integer.toString(Math.min(nodes[1].in,nodes[1].out)));
        bw.flush();
    }
}