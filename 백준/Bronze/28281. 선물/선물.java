import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=1,now = Integer.parseInt(st.nextToken()), next;i<N;i++,now=next){
            next = Integer.parseInt(st.nextToken());
            min = Math.min(min,now+next);
        }
        bw.write(Integer.toString(K*min));
        bw.flush();
    }
}