import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static class Node{
        boolean[] record;
        int num;
        Node(boolean[] record, boolean choice, int num){
            this.record = Arrays.copyOf(record,record.length+1);
            this.record[record.length] = choice;
            this.num = num;
        }
    }
    static Deque<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        next:for(int test = 1;test<=T;test++) {
            sb.setLength(0);
            q.clear();
            int n = Integer.parseInt(br.readLine());
            if(n==1){
                bw.write("1\n");
                continue;
            }
            boolean[] visit = new boolean[n];
            q.offerLast(new Node(new boolean[]{},true,1));
            visit[1] = true;
            while(!q.isEmpty()){
                Node now = q.pollFirst();
                if(now.num%n==0){
                    for(boolean b:now.record){
                        bw.write(b?'1':'0');
                    }
                    bw.write("\n");
                    continue next;
                }
                int n1 = (now.num*10+1)%n, n2 = (now.num*10)%n;
                if(!visit[n1]){
                    visit[n1] = true;
                    q.offerLast(new Node(now.record,true,n1));
                }
                if(!visit[n2]){
                    visit[n2] = true;
                    q.offerLast(new Node(now.record,false,n2));
                }
            }
        }
        bw.flush();
    }
}