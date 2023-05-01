import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long answer = Long.parseLong(st.nextToken())* Long.parseLong(st.nextToken());
        bw.write(Long.toString(answer>>1));
        bw.flush();
    }
}