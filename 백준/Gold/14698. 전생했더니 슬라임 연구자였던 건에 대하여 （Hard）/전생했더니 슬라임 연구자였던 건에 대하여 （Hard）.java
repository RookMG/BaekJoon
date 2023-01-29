import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            BigInteger answer = new BigInteger("1");
            PriorityQueue<BigInteger> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                pq.add(new BigInteger(st.nextToken()));
            }
            for(int i=0;i<n-1;i++){
                BigInteger a = pq.poll(), b = pq.poll();
                a = a.multiply(b);
                answer = answer.multiply(a);
                pq.add(a);
            }
            sb.append(answer.mod(new BigInteger("1000000007"))).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}