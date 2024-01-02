import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()), A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken()), ans = 1L;
        for(int a=0;a<A;a++) ans *= N--;
        for(int a=1;a<=A;a++) ans /= a;
        for(int a=0;a<B;a++) ans *= N--;
        for(int a=1;a<=B;a++) ans /= a;
        bw.write(Long.toString(ans));
        bw.flush();
    }
}