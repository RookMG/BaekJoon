import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        bw.write(Integer.toString((n+2)*(n+2)/4));
        bw.flush();
    }
}