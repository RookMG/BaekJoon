import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        bw.write(Integer.toString(Math.abs(Integer.parseInt(st.nextToken())- Integer.parseInt(st.nextToken())- Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken()))));
        bw.flush();
    }
}