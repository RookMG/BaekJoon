import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), X, ans = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        X = Integer.parseInt(br.readLine());
        for(int l = 0, r = N - 1; l<r; ){
            int cmp = Integer.compare(arr[l]+arr[r],X);
            switch(cmp){
                case 0: ans++;
                case 1: r--;break;
                case -1:l++;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}