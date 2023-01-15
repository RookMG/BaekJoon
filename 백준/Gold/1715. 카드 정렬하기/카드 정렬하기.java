import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), size = 0, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(pq.isEmpty()){
                System.out.println(sum);
                break;
            }
            int b = pq.poll();
            sum+=a+b;
            pq.add(a+b);
        }
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}