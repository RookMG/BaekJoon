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
        int[][] arr = new int[N][3];
        for(int i=0;i<N;i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        Arrays.sort(arr,(o1,o2)->Integer.compare(o1[0],o2[0]));
        for(int i=0;i<N;i++) arr[arr[i][1]][2] = i;
        for(int i=0;i<N;i++) sb.append(arr[i][2]).append(' ');
        bw.write(sb.toString());
        bw.flush();
    }
}