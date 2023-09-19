import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        bw.write("Nn".indexOf(br.readLine().charAt(0))<0?"Naver Whale":"Naver D2");
        bw.flush();
    }
}