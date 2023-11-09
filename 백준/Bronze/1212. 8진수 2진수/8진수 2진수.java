import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        sb.append(Integer.toBinaryString(input.charAt(0)-'0'));
        for(int i=1;i<input.length();i++){
            int num = input.charAt(i)-'0';
            if(num<4) sb.append('0');
            if(num<2) sb.append('0');
            sb.append(Integer.toBinaryString(num));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}