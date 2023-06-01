import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        for(;K<N&&K>0;K--) N = N%3==2?N-1:(N/3*2+N%3);
        bw.write(N>K?"water":"minigimbob");
        bw.flush();
    }
}