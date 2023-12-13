import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long ans = 1L;
        for(int i=0;i<5;i++) ans *= N-i;
        for(int i=1;i<=5;i++) ans /= i;
        bw.write(Long.toString(ans));
        bw.flush();
    }
}