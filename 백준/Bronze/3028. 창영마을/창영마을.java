import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[] move = {0b110,0b011,0b101};
    static final char[] code={'0','3','2','0','1'};
    public static void main(String[] args) throws Exception {
        int b = 0b100;
        for(char ch:br.readLine().toCharArray()) if((b&move[ch-'A'])!=0) b^=move[ch-'A'];
        bw.write(code[b]);
        bw.flush();
    }
}