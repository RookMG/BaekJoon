import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int i= Integer.parseInt(br.readLine());i>0;i--){
            for(int j= Integer.parseInt(br.readLine());j>0;j--) sb.append("=");
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}