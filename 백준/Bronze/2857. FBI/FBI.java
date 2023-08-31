import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        for(int i=1;i<=5;i++) if(br.readLine().contains("FBI")) sb.append(i).append(' ');
        bw.write(sb.length()==0?"HE GOT AWAY!":sb.toString());
        bw.flush();
    }
}