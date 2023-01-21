import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> qp = new PriorityQueue<>((e1,e2) -> e1[1]-e2[1]);
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if(N>=K){
            count = N-K;
            System.out.println(count);
            return;
        }
        count = K-N;
        qp.add(new int[]{N,0});
        boolean [] visited = new boolean[100001];
        while (!qp.isEmpty()){
            int[] poll = qp.poll();

            if(poll[1] > count || poll[0]<0 || poll[0]>100000){
                continue;
            }
            if(visited[poll[0]]){
                continue;
            }
            visited[poll[0]]=true;
            if(poll[0] >= K){
                count = Math.min(count, poll[1] + poll[0] - K);
                continue;
            }
            qp.add(new int[]{poll[0]*2, poll[1]});
            qp.add(new int[]{poll[0]+1, poll[1]+1});
            qp.add(new int[]{poll[0]-1, poll[1]+1});
        }
        System.out.println(count);
    }

}