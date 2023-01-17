import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        long answer = 0;
        PriorityQueue<int[]> jewels = new PriorityQueue<>((e1,e2) -> e1[0]-e2[0]);
        PriorityQueue<Integer> jewelSorted = new PriorityQueue<>();
        int[] bags = new int[k];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            jewels.offer(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        for(int i=0;i<k;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        for(int b:bags){
            while(!jewels.isEmpty()&&jewels.peek()[0]<=b){
                jewelSorted.offer(-jewels.poll()[1]);
            }
            if(!jewelSorted.isEmpty()){
                answer-=jewelSorted.poll();
            }else if(jewels.isEmpty()){
                break;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}