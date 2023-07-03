import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], withk = new int[N], arrRev = new int[N], withkRev = new int[N];
        for(int i=0;i<N;i++){
            withk[i] = (arr[i] = Integer.parseInt(st.nextToken())) + K*i;
            withkRev[N-1-i] = (arrRev[N-1-i] = arr[i]) + K*(N-1-i);
        }
        int ans = -Integer.MAX_VALUE, idx = 0, max = withk[0];
        for(int i=1;i<N;i++){
            ans = Math.max(ans,withk[idx]-withk[i]);
            if(max>withk[i]) continue;
            max = withk[i];
            idx = i;
        }
        idx = 0;
        max = withkRev[0];
        for(int i=1;i<N;i++){
            ans = Math.max(ans,withkRev[idx]-withkRev[i]);
            if(max>withkRev[i]) continue;
            max = withkRev[i];
            idx = i;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}