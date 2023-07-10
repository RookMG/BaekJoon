import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(),",");
		int s = 0;
        while(st.hasMoreTokens()) s+= Integer.parseInt(st.nextToken());
        bw.write(Integer.toString(s));
        bw.flush();
    }
}