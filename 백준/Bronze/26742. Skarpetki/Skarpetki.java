import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int[] res = {0,0};
        for(char ch:br.readLine().toCharArray()) res["BC".indexOf(ch)]++;
        bw.write(Integer.toString(res[0]/2+res[1]/2));
        bw.flush();
    }
}