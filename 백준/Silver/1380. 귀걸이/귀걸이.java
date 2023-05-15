import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int test = 1, n;(n= Integer.parseInt(br.readLine()))!=0;test++){
            String[] names = new String[n+1];
            for(int i=1;i<=n;i++) names[i] = br.readLine();
            int g = 0;
            for(int i=0;i<2*n-1;i++){
                st = new StringTokenizer(br.readLine());
                g^= Integer.parseInt(st.nextToken());
            }
            sb.append(test).append(' ').append(names[g]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}