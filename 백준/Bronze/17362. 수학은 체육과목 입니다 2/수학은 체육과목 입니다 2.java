import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int ans = (Integer.parseInt(br.readLine())-1)%8+1;
        bw.write(Integer.toString(Math.min(ans,10-ans)));
        bw.flush();
    }
}