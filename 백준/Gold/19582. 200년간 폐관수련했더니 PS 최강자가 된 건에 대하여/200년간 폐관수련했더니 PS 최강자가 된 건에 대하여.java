import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        long N = Long.parseLong(br.readLine()), max = 0, now = 0;
        String ans = "Kkeo-eok";
        boolean chance = true;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken()), c = Long.parseLong(st.nextToken());
            if(now <= r){
                now += c;
                max = Math.max(max, c);
            }else if(!chance){
                ans = "Zzz";
                break;
            }else{
                chance = false;
                now -= now-max<=r?Math.max(max-c,0):0;
            }
        }
        bw.write(ans);
        bw.flush();
    }
}