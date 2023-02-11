import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, i;
    public static void main(String[] args) throws Exception{
        if((n = Integer.parseInt(br.readLine()))<2){
            System.out.println(n); return;
        }
        for(i=1;i<n;i<<=1);
        System.out.println((n-(i>>1))<<1);
    }
}