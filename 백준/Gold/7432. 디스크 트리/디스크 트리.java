import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static class Node implements Comparable<Node>{
        ArrayList<Node> child;
        String name;
        Node(String name) {
            child = new ArrayList<>();
            this.name = name;
        }
        void sort() {
            Collections.sort(child);
            for(Node n:child) n.sort();
        }
        Node getByName(String name) {
            for(Node n:child) {
                if(n.name.equals(name)) {
                    return n;
                }
            }
            Node n = new Node(name);
            child.add(n);
            return n;
        }
        void print(int depth) throws Exception {
            for(int i=0;i<depth;i++) {
                bw.write(" ");
            }
            bw.write(name);
            bw.write('\n');
            for(Node n:child) {
                n.print(depth+1);
            }
        }
        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Node top = new Node(""), tmp;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(),"\\");
            tmp = top;
            while(st.hasMoreTokens()) {
                tmp = tmp.getByName(st.nextToken());
            }
        }
        top.sort();
        for(Node node:top.child)
            node.print(0);
        bw.flush();
    }
}