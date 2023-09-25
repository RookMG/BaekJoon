import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int s = Integer.parseInt(br.readLine()), e = Integer.parseInt(br.readLine());
        for(int i=s;i<=e;i+=60) sb.append("All positions change in year ").append(i).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}