import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int num, D, S, L, R;
        String cmd;
        public Node(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
            D = (num<<1)%10000;
            S = (num+9999)%10000;
            L = num*10%10000+num/1000;
            R = num/10+num%10*1000;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int t = Integer.parseInt(br.readLine());t>0;t--){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
            ArrayDeque<Node> dq = new ArrayDeque<>();
            HashSet<Integer> visit = new HashSet<>();
            dq.offerFirst(new Node(from, ""));
            visit.add(from);
            while(!dq.isEmpty()){
                Node now = dq.pollFirst();
                if(now.num==to){
                    sb.append(now.cmd).append('\n');
                    break;
                }
                if(!visit.contains(now.D)){
                    visit.add(now.D);
                    dq.offerLast(new Node(now.D, now.cmd+"D"));
                }
                if(!visit.contains(now.S)){
                    visit.add(now.S);
                    dq.offerLast(new Node(now.S, now.cmd+"S"));
                }
                if(!visit.contains(now.L)){
                    visit.add(now.L);
                    dq.offerLast(new Node(now.L, now.cmd+"L"));
                }
                if(!visit.contains(now.R)){
                    visit.add(now.R);
                    dq.offerLast(new Node(now.R, now.cmd+"R"));
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}