import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long sum = 0, cnt = 0;
        long[] arr = new long[N*2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            sum += arr[i] = arr[i+N] = Long.parseLong(st.nextToken());
        }
        for(int i=1;i<2*N;i++){
            arr[i] += arr[i-1];
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<=i+N;j++){
                if(arr[j]<arr[i]){
                    cnt += Math.ceil(1.0*(arr[i]-arr[j])/sum);
                }
            }
        }
        bw.write(Long.toString(cnt));
        bw.flush();
    }
}