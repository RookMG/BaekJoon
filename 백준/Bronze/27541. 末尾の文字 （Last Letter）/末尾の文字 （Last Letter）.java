import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        br.readLine();
        sb.append(br.readLine());
        if(sb.charAt(sb.length()-1)=='G') sb.setLength(sb.length()-1);
        else sb.append('G');
        bw.write(sb.toString());
        bw.flush();
    }
}