import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        br.readLine();
        br.readLine();
        StringBuilder sb = new StringBuilder(br.readLine());
        bw.write(sb.reverse().toString());
        bw.flush();
    }
}