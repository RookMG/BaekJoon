import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        while(true){
            st = new StringTokenizer(br.readLine());
            long lx = Integer.parseInt(st.nextToken()), ly = Integer.parseInt(st.nextToken()), lz = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken()), ans = Long.MAX_VALUE;
            if((lx|ly|lz|x|y|z)==0) break;
            if(x==0||y==0||z==0) sb.append(x*x+y*y+z*z).append('\n');
            else {
                if (lx == x) {
                    ans = Math.min(ans, (x + y) * (x + y) + z * z);
                    ans = Math.min(ans, (x + z) * (x + z) + y * y);
                    ans = Math.min(ans, (lz + y) * (lz + y) + (lx + lz - z) * (lx + lz - z));
                    ans = Math.min(ans, (ly + z) * (ly + z) + (lx + ly - y) * (lx + ly - y));
                }
                if (ly == y) {
                    ans = Math.min(ans, (x + y) * (x + y) + z * z);
                    ans = Math.min(ans, (y + z) * (y + z) + x * x);
                    ans = Math.min(ans, (lz + x) * (lz + x) + (ly + lz - z) * (ly + lz - z));
                    ans = Math.min(ans, (lx + z) * (lx + z) + (lx + ly - x) * (lx + ly - x));
                }
                if (lz == z) {
                    ans = Math.min(ans, (z + y) * (z + y) + x * x);
                    ans = Math.min(ans, (x + z) * (x + z) + y * y);
                    ans = Math.min(ans, (lx + y) * (lx + y) + (lx + lz - x) * (lx + lz - x));
                    ans = Math.min(ans, (ly + x) * (ly + x) + (lz + ly - y) * (lz + ly - y));
                }
                sb.append(ans).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}