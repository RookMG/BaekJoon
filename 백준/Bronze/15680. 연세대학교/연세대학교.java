import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        bw.write(Integer.parseInt(br.readLine())==0?"YONSEI":"Leading the Way to the Future");
        bw.flush();
    }
}