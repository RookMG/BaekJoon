import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        long n = Long.parseLong(br.readLine());

        bw.write((n%7==0||n%7==2)?"CY":"SK");

        bw.flush();

    }

}