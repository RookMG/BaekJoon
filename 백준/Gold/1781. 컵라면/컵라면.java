import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int deadline, value;
        Node(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> deadline = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.deadline,o2.deadline);
            }
        }), selected = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.value,o2.value);
            }
        });
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            deadline.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(Node node;!deadline.isEmpty();){
            node = deadline.poll();
            if(selected.size()<node.deadline) selected.add(node);
            else if(selected.peek().value<node.value){
                selected.poll();
                selected.add(node);
            }
        }
        long ans = 0L;
        for(Node node:selected) ans += node.value;
        bw.write(Long.toString(ans));
        bw.flush();
    }
}