import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) sb.append(String.format("Hello World, Judge %d!\n",i));
        bw.write(sb.toString());
        bw.flush();
    }
}