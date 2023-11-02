import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int[] arr = new int[Integer.parseInt(br.readLine())];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=arr.length;i++){
            int now = Integer.parseInt(st.nextToken());
            for(int j=0;j<arr.length;j++){
                if(arr[j]!=0) continue;
                if(now--==0) arr[j] = i;
            }
        }
        for (int num : arr) sb.append(num).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
}