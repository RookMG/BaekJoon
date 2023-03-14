import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int grundy = Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            grundy^=Integer.parseInt(st.nextToken());
        }
        bw.write(grundy==0?"cubelover":"koosaga");
        bw.flush();
    }
}