import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int n = a+b, m = a-b;
        if(a<b||n%2==1||m%2==1) bw.write("-1");
        else{
            bw.write(Integer.toString(n/2));
            bw.write(' ');
            bw.write(Integer.toString(m/2));
        }
        bw.flush();
    }
}