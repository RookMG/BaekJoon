import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        switch (Integer.compare(Integer.parseInt(st.nextToken())*7, Integer.parseInt(st.nextToken())*13)){
            case 1:
                bw.write("Axel");
                break;
            case 0:
                bw.write("lika");
                break;
            default:
                bw.write("Petra");
        }
        bw.flush();
    }
}