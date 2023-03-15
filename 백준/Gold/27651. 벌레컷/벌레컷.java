import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        long answer = 0, total = 0;
        long[] arr = new long[n], lsum = new long[n], rsum = new long[n], cnt = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            total += arr[i] = lsum[i] = rsum[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<n;i++){
            lsum[i] += lsum[i-1];
            rsum[n-1-i] += rsum[n-i];
        }
        for(int l=0, r=n-1;l<n;l++){
            while(r>=0&&lsum[l]>=rsum[r]) r--;
            cnt[l] = n-1-r;
        }
        for(int l=0, r=2;l<n;l++){
            while(r<n&&total-lsum[l]-rsum[r]<=rsum[r]) r++;
            answer += Math.max(0,n-r-cnt[l]);
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }
}