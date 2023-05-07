import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000002];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
            arr[Integer.parseInt(st.nextToken())+1]--;
        }
        for(int i=1;i<=1000001;i++) arr[i]+=arr[i-1];
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++) sb.append(arr[Integer.parseInt(st.nextToken())]).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}