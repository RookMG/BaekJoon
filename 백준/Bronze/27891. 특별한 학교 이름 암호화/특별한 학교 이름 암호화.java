import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        char[] line = br.readLine().toCharArray();
        int d = (line[4]+26-line[3])%26;
        switch (d){
            case 23:
                bw.write("BHA");
                break;
            case 19:
                bw.write("SJA");
                break;
            case 14:
                bw.write("NLCS");
                break;
            case 22:
                bw.write("KIS");
                break;
        }
        bw.flush();
    }
}