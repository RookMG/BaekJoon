import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] fib0 = new int[41], fib1 = new int[41];
        fib0[0] = 1;
        fib1[1] = 1;
        for(int i=2;i<41;i++){
            fib0[i]+=fib0[i-1]+fib0[i-2];
            fib1[i]+=fib1[i-1]+fib1[i-2];
        }
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(fib0[num]).append(" ").append(fib1[num]).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}