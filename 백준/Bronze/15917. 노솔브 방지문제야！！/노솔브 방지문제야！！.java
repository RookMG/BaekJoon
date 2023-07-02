import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--) sb.append(Integer.bitCount(Integer.parseInt(br.readLine()))==1?"1\n":"0\n");
        bw.write(sb.toString());
        bw.flush();
    }
}