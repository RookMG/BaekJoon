import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        int max = arr[N-1], diff;
        for(int i=N-2;i>=0;i--){
            diff = arr[i] - max +1;
            if(diff>0){
                max--;
                ans+=diff;
            }else max = arr[i];
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}