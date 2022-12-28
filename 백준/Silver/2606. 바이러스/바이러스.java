import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), l = Integer.parseInt(br.readLine()), answer = 0;
        LinkedList<LinkedList<Integer>> links = new LinkedList<LinkedList<Integer>>();
        for(int i=0;i<n+1;i++){
            links.offer(new LinkedList());
        }
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);
        for(int i=0;i<l;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),b = Integer.parseInt(st.nextToken());
            links.get(a).offer(b);
            links.get(b).offer(a);
        }
        q.offer(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int now = q.pop();
            for(int i=0;i<links.get(now).size();i++){
                int next = links.get(now).get(i);
                if(!visited[next]){
                    q.offer(next);
                    visited[next]=true;
                    answer+=1;
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}