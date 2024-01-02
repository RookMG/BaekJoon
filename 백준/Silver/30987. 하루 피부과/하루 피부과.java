import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), ans = 0;
        st = new StringTokenizer(br.readLine());
        ans += Integer.parseInt(st.nextToken())*(e*e*e-s*s*s)/3;
        ans += Integer.parseInt(st.nextToken())*(e*e-s*s)/2;
        ans += Integer.parseInt(st.nextToken())*(e-s);
        ans -= Integer.parseInt(st.nextToken())*(e*e-s*s)/2;
        ans -= Integer.parseInt(st.nextToken())*(e-s);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}