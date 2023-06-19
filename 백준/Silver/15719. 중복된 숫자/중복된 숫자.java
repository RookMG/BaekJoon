import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        long N = Integer.parseInt(br.readLine()), sum = -N*(N-1)/2;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) sum += Long.parseLong(st.nextToken());
        bw.write(Long.toString(sum));
        bw.flush();
    }
}
