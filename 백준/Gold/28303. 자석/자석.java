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
        int[] arr = new int[N], arrRev = new int[N];
        for(int i=0;i<N;i++){
            arrRev[N-1-i] += arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += i*K;
            arrRev[i] += i*K;
        }
        int ans = -Integer.MAX_VALUE, idx = 0, max = arr[0];
        for(int i=1;i<N;i++){
            ans = Math.max(ans,arr[idx]-arr[i]);
            if(max>arr[i]) continue;
            max = arr[i];
            idx = i;
        }
        idx = 0;
        max = arrRev[0];
        for(int i=1;i<N;i++){
            ans = Math.max(ans,arrRev[idx]-arrRev[i]);
            if(max>arrRev[i]) continue;
            max = arrRev[i];
            idx = i;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}