import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int i= Integer.parseInt(br.readLine());i>0;i--) sb.append(Long.parseLong(br.readLine())<2?"1 0\n":"0 1\n");
        bw.write(sb.toString());
        bw.flush();
    }
}