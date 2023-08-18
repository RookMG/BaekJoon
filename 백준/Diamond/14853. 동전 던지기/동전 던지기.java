import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int T= Integer.parseInt(br.readLine());T>0;T--){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()), m1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken()), m2 = Integer.parseInt(st.nextToken());
            double ans = 1.0, mul;
            for(int i=0;i<=m1;i++) ans*=1.0*(n1+1-i)/(n1+n2+2-i);
            mul = ans;
            for(int i=0;i<m2;i++) ans+=mul*=1.0*(m1+i+1)/(i+1)*(n2+1-i)/(n1+n2-m1+1-i);
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}