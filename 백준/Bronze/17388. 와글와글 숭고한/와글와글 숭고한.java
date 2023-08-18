import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        if(a+b+c>=100) bw.write("OK");
        else if(a<b&&a<c) bw.write("Soongsil");
        else if(b<c) bw.write("Korea");
        else bw.write("Hanyang");
        bw.flush();
    }
}