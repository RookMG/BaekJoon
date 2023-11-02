import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        int[] arr = new int[N-1];
        for(int i=N-2;i>=0;i--) arr[i] = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine()), diff;
        for(int next:arr){
            diff = next - max +1;
            ans += Math.max(0,diff);
            max = diff>0?max-1:next;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}