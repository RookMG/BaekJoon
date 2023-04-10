import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), div = Integer.parseInt(st.nextToken());
        bw.write(Integer.toString(Math.min(n,(r/div)*(c/div))));
        bw.flush();
    }
}