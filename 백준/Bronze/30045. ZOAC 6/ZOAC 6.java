import java.io.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        for(int i=0;i<N;i++){
            String s = br.readLine();
            ans += (s.contains("01")||s.contains("OI"))?1:0;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}