import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        String s;
        while((s = br.readLine()) != null && !s.equals("")) sb.append(s).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}