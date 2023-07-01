import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static HashMap<Long, Long> dp = new HashMap<>();
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());
            sb.append(recur(x,y)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static long recur(long l, long r){
        if((l|r)==0) return 0L;
        if(dp.containsKey((l<<32)+r)) return dp.get((l<<32)+r);
        long ret = 0;
        for(int i=1;i<=32;i++){
            long cl = Math.max(l,(1L<<i)-1), cr = Math.min(r,(1L<<(i+1))-2);
            if(cl>cr) continue;
            ret = Math.max(ret,i+recur(cl-(1L<<i)+1,cr-(1L<<i)+1));
        }
        dp.put((l<<32)+r,ret);
        return ret;
    }
}