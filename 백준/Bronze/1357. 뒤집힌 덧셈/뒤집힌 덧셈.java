import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int ans = Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
        sb.setLength(0);
        ans += Integer.parseInt(sb.append(st.nextToken()).reverse().toString());
        sb.setLength(0);
        sb.append(ans).reverse();
        bw.write(Integer.toString(Integer.parseInt(sb.toString())));
        bw.flush();
    }
}