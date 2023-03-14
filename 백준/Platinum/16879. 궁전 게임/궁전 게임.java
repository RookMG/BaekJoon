import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine()), g = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            g^=grundy(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        bw.write(g==0?"cubelover":"koosaga");
        bw.flush();
    }
    static int grundy(int a, int b){
        return ((a/3)^(b/3))*3+(a+b)%3;
    }
}