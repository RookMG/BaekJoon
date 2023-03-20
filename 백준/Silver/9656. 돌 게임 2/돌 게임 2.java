import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        bw.write(n%2!=0?"CY":"SK");

        bw.flush();

    }

}