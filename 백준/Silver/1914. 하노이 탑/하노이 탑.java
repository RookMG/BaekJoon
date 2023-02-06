import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
	static void hanoi(int btm, int from, int goal){
		if(btm == 0){
			return;
		}
		hanoi(btm-1,from,6-from-goal);
		sb.append(from).append(" ").append(goal).append("\n");
		hanoi(btm-1,6-from-goal,goal);
	}
    public static void main(String[] args) throws Exception{
    	int n = Integer.parseInt(br.readLine());
    	sb.append(new BigInteger("2").pow(n).subtract(new BigInteger("1"))).append("\n");
		if(n<=20)hanoi(n,1,3);
    	System.out.print(sb);
    }
}