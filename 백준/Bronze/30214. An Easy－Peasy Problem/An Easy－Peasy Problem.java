import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        bw.write(Integer.parseInt(st.nextToken())<<1<Integer.parseInt(st.nextToken())?'H':'E');
        bw.flush();
    }
}