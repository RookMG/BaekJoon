import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), s = 0, e = Integer.parseInt(st.nextToken()), J = Integer.parseInt(br.readLine()), ans = 0;
        for(int i=0;i<J;i++){
            int now = Integer.parseInt(br.readLine()), d = 0;
            if(s<now&&now<=e) continue;
            if(now<=s){
                d = s+1-now;
                ans += d;
                s -= d;
                e -= d;
            }else{
                d = now-e;
                ans += d;
                s += d;
                e += d;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}