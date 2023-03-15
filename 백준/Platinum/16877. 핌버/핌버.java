import java.io.*;
import java.util.*;
public class Main {
    static final int[] fiv = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine()), g = 0;
        st = new StringTokenizer(br.readLine());
        dp = new int[3000001];
        boolean[] mex = new boolean[17];
        for (int i = 1; i <= 3; i++) dp[i] = i;
        for(int i=4;i<=3000000;i++){
            Arrays.fill(mex,false);
            for(int j:fiv){
                if(j>i) break;
                mex[dp[i-j]] = true;
            }
            for(int k=0;k<17;k++){
                if (!mex[k]) {
                    dp[i] = k;
                    break;
                }
            }
        }
        while(st.hasMoreTokens()) g ^= dp[Integer.parseInt(st.nextToken())];
        bw.write(g == 0 ? "cubelover" : "koosaga");
        bw.flush();
    }
}