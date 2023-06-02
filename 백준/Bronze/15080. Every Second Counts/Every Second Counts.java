import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine().replace(':',' '));
        int a = Integer.parseInt(st.nextToken())*3600+ Integer.parseInt(st.nextToken())*60+ Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine().replace(':',' '));
        int b = Integer.parseInt(st.nextToken())*3600+ Integer.parseInt(st.nextToken())*60+ Integer.parseInt(st.nextToken());
        bw.write(Integer.toString(b<a?b-a+3600*24:b-a));
        bw.flush();
    }
}