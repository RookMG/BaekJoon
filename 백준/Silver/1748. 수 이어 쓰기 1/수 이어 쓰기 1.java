import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        for(int now = 1, cnt=1;now<=N;now=now*10,cnt++){
            ans += cnt*(Math.min(now*10-1,N)-(now)+1);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}