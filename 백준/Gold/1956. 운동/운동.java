import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX = 100_000_000;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), ans = MAX;
        int[][] arr = new int[V+1][V+1];
        for(int i=1;i<=V;i++) Arrays.fill(arr[i],MAX);
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                for(int k=1;k<=V;k++){
                    arr[i][k] = Math.min(arr[i][k],arr[i][j]+arr[j][k]);
                }
            }
        }
        for(int i=1;i<=V;i++) ans = Math.min(ans,arr[i][i]);
        bw.write(Integer.toString(ans==MAX?-1:ans));
        bw.flush();
    }
}