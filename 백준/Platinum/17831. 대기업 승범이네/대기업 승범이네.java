import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        ArrayList<Node> child;
        int score, on, off;
        Node(){
            child = new ArrayList<>();
            score = on = off = 0;
        }
        void dp(){
            for(Node n:child){
                n.dp();
                off += Math.max(n.on,n.off);
            }
            for(Node n:child){
                on = Math.max(on,off-Math.max(n.on,n.off)+n.off+score*n.score);
            }
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Node[] tree = new Node[N+1];
        for(int i=1;i<=N;i++){
            tree[i] = new Node();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=2;i<=N;i++){
            tree[Integer.parseInt(st.nextToken())].child.add(tree[i]);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            tree[i].score = Integer.parseInt(st.nextToken());
        }
        tree[1].dp();
        bw.write(Integer.toString(Math.max(tree[1].on,tree[1].off)));
        bw.flush();
    }
}