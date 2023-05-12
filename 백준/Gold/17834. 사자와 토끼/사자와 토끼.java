import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), even = 0, odd = 0;
        int[] visit = new int[N+1];
        ArrayList<Integer>[] links = new ArrayList[N+1];
        for(int i=1;i<=N;i++) links[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            links[a].add(b);
            links[b].add(a);
        }
        visit[1] = 1;
        odd++;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        bfs : while(!dq.isEmpty()){
            int now = dq.pollFirst();
            for(int next:links[now]){
                if(visit[next]==0){
                    visit[next] = 3 - visit[now];
                    if(visit[next]==1) odd++;
                    else even++;
                    dq.offerLast(next);
                }else if(visit[next]==visit[now]){
                    even = 0;
                    break bfs;
                }
            }
        }
        bw.write(Integer.toString(2*even*odd));
        bw.flush();
    }
}