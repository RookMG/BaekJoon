import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        switch(br.readLine().charAt(0)) {
            case 'N':
                bw.write("North London Collegiate School");
                break;
            case 'B':
                bw.write("Branksome Hall Asia");
                break;
            case 'K':
                bw.write("Korea International School");
                break;
            case 'S':
                bw.write("St. Johnsbury Academy");
                break;
        }
        bw.flush();
    }
}