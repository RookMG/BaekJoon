import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        sb.append("Gnomes:");
        for(int i= Integer.parseInt(br.readLine()), a, b, c;i>0;--i){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
            sb.append((a<b&&b<c)||(a>b&&b>c)?"\nOrdered":"\nUnordered");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}