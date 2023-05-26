import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        char[] line = br.readLine().toCharArray();
        for(int i=0;i<line.length;i++){
            sb.append(line[i]);
            if(i%10==9) sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}