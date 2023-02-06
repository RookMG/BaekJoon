import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
    static StringTokenizer st;
    public static void recursion(String s, int l, int r, int n){
        if(l >= r) System.out.printf("1 %d\n",n);
        else if(s.charAt(l) != s.charAt(r)) System.out.printf("0 %d\n",n);
        else recursion(s, l+1, r-1, n+1);
    }
    public static void palindrome(String s){
        recursion(s, 0, s.length()-1,1);
    }
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) palindrome(br.readLine());
    }
}