import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    boolean visited[];
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[200000];
        q.offer(new int[]{n,0});
        visited[n]=true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==k){
                System.out.println(now[1]);
                break;
            }
            if(2*now[0]<100001&&!visited[2*now[0]]){
                visited[2*now[0]]=true;
                q.offer(new int[]{2*now[0],now[1]+1});
            }
            if(now[0]+1<100001&&!visited[now[0]+1]){
                visited[now[0]+1]=true;
                q.offer(new int[]{now[0]+1,now[1]+1});
            }
            if(now[0]>0&&!visited[now[0]-1]){
                visited[now[0]-1]=true;
                q.offer(new int[]{now[0]-1,now[1]+1});
            }
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}