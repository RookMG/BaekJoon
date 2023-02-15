import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->Math.abs(o1)==Math.abs(o2)?o1-o2:Math.abs(o1)-Math.abs(o2));
        for(int i=0;i<n;i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num==0) {
        		sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
        	}else {
        		pq.add(num);
        	}
        }
        System.out.print(sb);
    }
}