import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] visit;
    int n, k;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int min = Math.abs(n-k), ways=0;
        visit = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {n, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            visit[now[0]] = true;
            if(k==now[0]){
                if(min==now[1]){
                    ways++;
                }else if(min>now[1]){
                    min = now[1];
                    ways = 1;
                }
            }
            if(valid(2*now[0])){
                q.offer(new int[]{2*now[0],now[1]+1});
            }
            if(valid(now[0]+1)){
                q.offer(new int[]{now[0]+1,now[1]+1});
            }
            if(valid(now[0]-1)){
                q.offer(new int[]{now[0]-1,now[1]+1});
            }
        }
        sb.append(min).append("\n").append(ways);
        System.out.println(sb);
    }
    static boolean valid(int p){
        return 0<=p&&p<100001&&!visit[p];
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}