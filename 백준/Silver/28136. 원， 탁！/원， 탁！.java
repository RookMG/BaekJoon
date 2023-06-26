import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[N] = arr[0];
        for(int i=1;i<=N;i++) if(arr[i]<=arr[i-1]) ans++;
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}