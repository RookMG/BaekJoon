import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        bw.write((k<0?(a+b!=1&&((a==b&&a==1)||k==-1||a!=b)):a!=b)?"First":"Second");
        bw.flush();
    }
}