import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int ans = 0, now = 0;
        for(int i=0;i<10;i++){
            st = new StringTokenizer(br.readLine());
            now += -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            ans = Math.max(ans,now);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}