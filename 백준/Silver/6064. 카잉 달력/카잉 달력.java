import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        test:for(int T = Integer.parseInt(br.readLine());T>0;T--){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), ans = x;
            for(;M*N>=ans;ans+=M){
                if((ans-1)%N!=y-1) continue;
                sb.append(ans).append('\n');
                continue test;
            }
            sb.append(-1).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}