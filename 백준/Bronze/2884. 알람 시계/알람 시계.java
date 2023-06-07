import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int time = 60* Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken()) + 60*24 - 45;
        sb.append(time/60%24).append(' ').append(time%60);
        bw.write(sb.toString());
        bw.flush();
    }
}