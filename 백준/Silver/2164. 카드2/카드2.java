import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n, i;
        if((n = Integer.parseInt(br.readLine()))<3){
            System.out.println(n); return;
        }
        for(i=4;i<n;i<<=1);
        System.out.println((n-(i>>1))<<1);
    }
}