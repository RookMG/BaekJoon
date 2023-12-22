import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static double ans;
    static int[][] arr;
    static boolean[] selected;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            selected = new boolean[N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                ans = Double.MAX_VALUE;
            }
            recur(0,N>>1);
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void recur(int start, int left){
        if(start==N){
            if(left!=0) return;
            double x = 0.0, y = 0.0;
            for(int i=0;i<N;i++){
                x += selected[i]?arr[i][0]:-arr[i][0];
                y += selected[i]?arr[i][1]:-arr[i][1];
            }
            ans = Math.min(ans,Math.sqrt(x*x+y*y));
            return;
        }
        if(start+left<N) recur(start+1,left);
        selected[start] = true;
        recur(start+1,left-1);
        selected[start] = false;
    }
}