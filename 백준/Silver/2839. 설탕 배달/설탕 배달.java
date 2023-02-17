import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        System.out.print((n==4||n==7)?-1:n/5 +(n%5>0?(n%5-1)%2+1:0));
    }
}