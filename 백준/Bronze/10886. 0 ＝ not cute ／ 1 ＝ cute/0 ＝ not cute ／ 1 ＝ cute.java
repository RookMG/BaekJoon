import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), sum = 0;
        for(int i=0;i<N;i++) sum += Integer.parseInt(br.readLine());
        bw.write(String.format("Junhee is%s cute!",(sum<<1)>N?"":" not"));
        bw.flush();
    }
}