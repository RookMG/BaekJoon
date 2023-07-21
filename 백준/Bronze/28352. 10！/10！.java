import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long ans = 6;
        for(int i=11;i<=N;i++) ans*=i;
        bw.write(Long.toString(ans));
        bw.flush();
    }
}