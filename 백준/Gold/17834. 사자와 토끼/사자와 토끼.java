import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] visit = new int[N+1], answer = new int[3];
        ArrayList<Integer>[] links = new ArrayList[N+1];
        for(int i=1;i<=N;i++) links[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            links[a].add(b);
            links[b].add(a);
        }
        answer[visit[1] = 1]++;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        bfs : while(!dq.isEmpty()){
            int now = dq.pollFirst();
            for(int next:links[now]){
                if(visit[next]==visit[now]){
                    answer[1] = 0;
                    break bfs;
                }
                if(visit[next]==0){
                    answer[visit[next] = 3 - visit[now]]++;
                    dq.offerLast(next);
                }
            }
        }
        bw.write(Integer.toString(2*answer[1]*answer[2]));
        bw.flush();
    }
}