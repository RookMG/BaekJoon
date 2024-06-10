import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashSet<Integer> set = new HashSet<>();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), X, ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) set.add(Integer.parseInt(st.nextToken()));
        X = Integer.parseInt(br.readLine());
        for(int i=(X>>1) + 1;i<X;i++) if(set.contains(i)&&set.contains(X-i)) ans++;
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}