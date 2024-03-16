import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
        for(long i=A;i<=B;i++){
            if(BigInteger.valueOf(i).isProbablePrime(10) ||i==9){
                sb.append(i).append(' ');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}