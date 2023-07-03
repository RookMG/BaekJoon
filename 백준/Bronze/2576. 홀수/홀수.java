import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int m = Integer.MAX_VALUE, s = 0;
        for(int i=0;i<7;i++){
            int n = Integer.parseInt(br.readLine());
            if(n%2==0) continue;
            m = Math.min(m,n);
            s+=n;
        }
        sb.append(String.format("%d\n%d",s,m));
        bw.write(s==0?"-1":sb.toString());
        bw.flush();
    }
}