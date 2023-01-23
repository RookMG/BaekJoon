import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        while(!pq.isEmpty()){
            int small = pq.poll();
            if(small>l){
                break;
            }else{
                l++;
            }
        }
        System.out.println(l);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}