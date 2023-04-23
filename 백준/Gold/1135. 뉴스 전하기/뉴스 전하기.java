import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static class Node{
        int idx, in, out;
        ArrayList<Node> childs;
        Node(int idx){
            this.idx = idx;
            in = 1;
            out = 0;
            childs = new ArrayList<>();
        }
        int update(){
            if(childs.isEmpty()) return 0;
            int[] time = new int[childs.size()];
            for(int i=0;i<childs.size();i++){
                time[i] = childs.get(i).update();
            }
            Arrays.sort(time);
            for(int i=0;i<childs.size();i++){
                time[i]+=childs.size()-i;
            }
            Arrays.sort(time);
            return time[childs.size()-1];
        }
    }
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i=0;i<N;i++){
            nodes[i] = new Node(i);
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i=1;i<N;i++) {
            int a = Integer.parseInt(st.nextToken());
            nodes[a].childs.add(nodes[i]);
        }
        bw.write(Integer.toString(nodes[0].update()));
        bw.flush();
    }
}