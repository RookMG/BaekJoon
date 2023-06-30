import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[] T, V;
    static long ans = -1;
    static int N, D;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        T = new long[N+1];
        V = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) T[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) V[i] = Integer.parseInt(st.nextToken());
        recur(1,N,1,N);
        bw.write(Long.toString(ans));
        bw.flush();
    }
    static void recur(int l, int r, int cl, int cr){
        if(l > r) return;
        int m = (l + r) >> 1, tmp = Math.max(cl,m-D);
        for(int i=tmp; i<=Math.min(cr,m); i++){
            if((m-tmp)*T[m]+V[tmp]>=(m-i)*T[m]+V[i]) continue;
            tmp = i;
        }
        ans = Math.max(ans,(m-tmp)*T[m]+V[tmp]);
        recur(l, m-1, cl, tmp);
        recur(m+1, r, tmp, cr);
    }
}