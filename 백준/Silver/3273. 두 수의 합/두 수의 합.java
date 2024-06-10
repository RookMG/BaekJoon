import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] set = new boolean[2000001];
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), X, ans = 0, end;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) set[Integer.parseInt(st.nextToken())] = true;
        X = Integer.parseInt(br.readLine());
        for(int i=(X>>1) + 1;i<X;i++) if(set[i]&&set[X-i]) ans++;
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}