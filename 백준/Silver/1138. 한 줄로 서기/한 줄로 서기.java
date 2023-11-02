import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=1;i<=N;i++){
            int now = Integer.parseInt(st.nextToken());
            for(int j=0;j<N;j++){
                if(arr[j]!=0) continue;
                if(now==0) arr[j] = i;
                now--;
            }
        }
        for(int i=0;i<N;i++) sb.append(arr[i]).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
}