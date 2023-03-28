import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken()), mid = 0;
        long[] arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        for(long left = 0, right = Long.MAX_VALUE/2;left<right;){
            mid = (left+right)/2;
            long now = 0;
            for(long l : arr){
                if(now>M) break;
                now+= mid/l;
            }
            if(M>now) left = mid;
            else right = mid;
            mid = (left+right)/2;
            if(left==right-1){
                mid = right;
                break;
            }
        }
        bw.write(Long.toString(mid));
        bw.flush();
    }
}