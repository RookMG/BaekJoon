import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[4][N+1];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1, idx;i<=N;i++){
            idx = Arrays.binarySearch(arr[0],arr[0][i]-arr[1][i]);
            arr[3][i] = Math.max(arr[3][i-1],arr[2][i] + ((idx=idx<0?-idx-1:idx)>0?arr[3][idx-1]:0));
        }
        bw.write(Long.toString(arr[3][N]));
        bw.flush();
    }
}