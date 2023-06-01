import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N+1];
        String ans = "water";
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerFirst(0);
        bfs:for(int time = 0, now;!q.isEmpty()&&time<=K;time++){
            for(int size = q.size();size>0;size--){
                now = q.pollFirst();
                if(now==N){
                    ans = "minigimbob";
                    break bfs;
                }
                if(now<N&&!visit[now+1]){
                    visit[now+1]=true;
                    q.offerLast(now+1);
                }
                if(now+(now>>1)<=N&&!visit[now+(now>>1)]){
                    visit[now+(now>>1)]=true;
                    q.offerLast(now+(now>>1));
                }
            }
        }
        bw.write(ans);
        bw.flush();
    }
}