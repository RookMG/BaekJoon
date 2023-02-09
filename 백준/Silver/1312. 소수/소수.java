import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n-1;i++) {
        	a = (10*a%b);
        }
        System.out.println((10*a/b)%10);
    }
}