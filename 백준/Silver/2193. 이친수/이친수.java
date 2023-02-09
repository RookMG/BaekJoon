import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        long[][] count = new long[n][2];
        count[0][1]=1;
        for(int i=1;i<n;i++) {
        	count[i][0] = count[i-1][0]+count[i-1][1];
        	count[i][1] = count[i-1][0];
        }
        System.out.println(count[n-1][0]+count[n-1][1]);
    }
}