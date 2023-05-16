import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), a = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++) a += Math.min(N, Integer.parseInt(st.nextToken()));
        bw.write(Integer.toString(a));
        bw.flush();
    }
}