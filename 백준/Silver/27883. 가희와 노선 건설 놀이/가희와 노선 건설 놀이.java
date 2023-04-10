import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken()),h=1;
        sb.append(2*q+1).append("\n");
        sb.append("U 1 -1\n");
        for(int i=0;i<q;i++){
            sb.append(String.format("U %d %d\nP\n",Integer.parseInt(br.readLine())+1,h++));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}