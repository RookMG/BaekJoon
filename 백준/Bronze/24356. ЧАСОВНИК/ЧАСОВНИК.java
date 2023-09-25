import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int t = (1440-Integer.parseInt(st.nextToken())*60-Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken()))%1440;
        sb.append(t).append(' ').append(t/30);
        bw.write(sb.toString());
        bw.flush();
    }
}