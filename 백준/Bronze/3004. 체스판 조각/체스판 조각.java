import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine()), row = 1 + n/2, col = 1 + n/2 + n%2;
        bw.write(Integer.toString(row*col));
        bw.flush();
    }
}