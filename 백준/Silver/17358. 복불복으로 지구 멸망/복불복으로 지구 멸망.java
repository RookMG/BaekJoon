import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long ans = 1;
        for(int i=N-1;i>0;i-=2) ans=(ans*i)%1000000007;
        bw.write(Long.toString(ans));
        bw.flush();
    }
}