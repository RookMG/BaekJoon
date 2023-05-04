import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            char[] B = st.nextToken().toCharArray();
            int maxcnt=0, mincnt=0, maxfirst=0, minfirst = 0;
            for(int i=B.length-1;i>=0;i--){
                if(B[i]=='1'){
                    maxfirst = Math.max(maxfirst,B.length-i);
                    minfirst = Math.max(minfirst,B.length-i);
                    mincnt++;
                    maxcnt++;
                }else if(B[i]=='?'){
                    maxfirst = Math.max(maxfirst,B.length-i);
                    maxcnt++;
                }
            }
            if(A==1){
                sb.append(maxcnt == 0 ? 1 : maxfirst).append(' ').append(mincnt == 0 ? 1 : minfirst).append('\n');
            }else {
                sb.append(maxcnt > 1 ? A + maxfirst : maxcnt == 0 ? 1 : A + maxfirst - 1).append(' ').append(mincnt > 1 ? A + minfirst : mincnt == 0 ? 1 : A + minfirst - 1).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}