import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            long sum = 0L;
            int N = Integer.parseInt(br.readLine()), max = 0;
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++) arr[N-1-i] = Integer.parseInt(st.nextToken());
            max = arr[0];
            for(int i=1;i<N;i++){
                sum += Math.max(0,max-arr[i]);
                max = Math.max(max,arr[i]);
            }
            sb.append(sum).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}