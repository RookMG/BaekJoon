import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] use = new int[10];
        while(n!=0) {
        	use[n%10]++;
        	n/=10;
        }
        use[6] = (use[6]+use[9]+1)/2;
        use[9] = 0;
        Arrays.sort(use);
        System.out.println(use[9]);
    }
}