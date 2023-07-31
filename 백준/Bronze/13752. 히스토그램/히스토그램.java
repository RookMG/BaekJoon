import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int i= Integer.parseInt(br.readLine());i>0;i--, sb.append('\n')) for(int j= Integer.parseInt(br.readLine());j>0;j--) sb.append("=");
        bw.write(sb.toString());
        bw.flush();
    }
}