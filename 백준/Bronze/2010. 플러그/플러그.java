import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int ans = 1;
        for(int i=Integer.parseInt(br.readLine());i>0;i--) ans += Integer.parseInt(br.readLine())-1;
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}