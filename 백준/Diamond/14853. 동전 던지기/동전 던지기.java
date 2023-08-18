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
            int n1 = Integer.parseInt(st.nextToken())+1, m1 = Integer.parseInt(st.nextToken())+1, n2 = Integer.parseInt(st.nextToken())+1, m2 = Integer.parseInt(st.nextToken());
            double ans = 1.0, mul;
            for(int i=0;i<m1;i++) ans=ans*(n1-i)/(n1+n2-i);
            mul = ans;
            for(int i=0;i<m2;i++) ans+=mul=mul*(m1+i)/(i+1)*(n2-i)/(n1+n2-m1-i);
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}