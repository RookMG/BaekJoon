import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), w=Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        Queue<Integer> q =new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            q.offer(Integer.parseInt(st.nextToken()));
        }
        LinkedList<int[]> bridge = new LinkedList<>();
        int total = 0, next = 0, time = 0;
        for(;!q.isEmpty();time++){
            next = q.peek();
            for(int i=bridge.size()-1;i>=0;i--){
                int[] truck = bridge.get(i);
                if(++truck[1]==w){
                    total-=truck[0];
                    bridge.remove(i);
                }
            }
            if(total+next<=L){
                total+=next;
                bridge.add(new int[]{q.poll(),0});
            }
        }
        if(!bridge.isEmpty()){time+=(w-bridge.get(bridge.size()-1)[1]);}
        System.out.println(time);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}