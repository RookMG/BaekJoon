import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            st = new StringTokenizer(br.readLine());
            long P = Long.parseLong(st.nextToken()), Q = Long.parseLong(st.nextToken()), N = Long.parseLong(st.nextToken()), G = GCD(P,Q);
            sb.append((P*N*(N+1)>>1)-Q*recur(P/G,Q/G,N)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static long GCD(long a, long b){
        return b>0?GCD(b,a%b):a;
    }
    static long recur(long a, long b, long c){
        if(a==0) return a;
        return a<b?(a*c/b)*c+c/b-recur(b,a,a*c/b):((a/b)*c*(c+1)>>1)+recur(a%b,b,c);
    }
}