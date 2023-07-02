import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine()),now;T>0;T--){
            now = Integer.parseInt(br.readLine());
            sb.append((now&(-now))==now?"1\n":"0\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}