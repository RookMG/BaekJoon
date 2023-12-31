import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final long MOD = 1_000_000_007, DIV = 500_000_004;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()), b = a-1;
        for(int i=Integer.parseInt(st.nextToken());i>0;i--){
            a = a*b%MOD*DIV%MOD;
            b = ((b-1)<<1)%MOD;
        }
        bw.write(Long.toString(a));
        bw.flush();
    }
}