import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        long N = Integer.parseInt(s), K = Integer.parseInt(st.nextToken()), mul = (long) Math.pow(10,s.length()), ans = 1;
        boolean[] visit = new boolean[(int)K];
        for(int now = (int)(N%K);;ans++){
            if(visit[now]){
                ans = -1;
                break;
            }
            if(now==0) break;
            visit[now] = true;
            now = (int)((now*mul+N)%K);
        }
        bw.write(Long.toString(ans));
        bw.flush();
    }
}