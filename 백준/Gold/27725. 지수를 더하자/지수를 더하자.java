import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long target = Long.parseLong(br.readLine()), answer = 0;
        for(int i=0;i<n;i++){
            long now = Long.parseLong(st.nextToken());
            for(long p = now;p<=target;p*=now){
                answer += target/p;
            }
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
}