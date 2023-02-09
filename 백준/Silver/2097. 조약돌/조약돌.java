import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        for(int a=2;;a++) {
        	if(n<=(a+1)*a) {
        		System.out.println(n<=a*a?4*(a-1):4*a-2);
        		break;
        	}
        }
    }
}