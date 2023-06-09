// https://ajc.maths.uq.edu.au/pdf/20/ocr-ajc-v20-p19.pdf
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 1;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=1;i<=N;i++){
            arr[i] += arr[i-1];
            if(arr[i]>=i*(i-1)>>1) continue;
            ans = -1;
            break;
        }
        if(arr[N]!=N*(N-1)>>1) ans = -1;
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}