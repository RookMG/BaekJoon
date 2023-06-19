import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder("-1");
    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine()), s = 5*n*n+10*n+1, r = (long)Math.sqrt(s);
        if(r*r==s){
            long a = 2*n, b = n+r+1, c = 2*n, d = n-r+1, ga = gcd(a,b), gc = gcd(c,Math.abs(d));
            if(a/ga*c/gc==n) {
                sb.setLength(0);
                sb.append(a / ga).append(' ').append(b / ga).append(' ').append(c / gc).append(' ').append(d / gc);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static long gcd(long a, long b){
        long tmp;
        if(a<b){ tmp=a; a=b; b=tmp; }
        while(b!=0){
            a %= b;
            tmp = a;
            a = b;
            b = tmp;
        }
        return a;
    }
}