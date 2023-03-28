import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[] coin = {500,100,50,10,5,1};
    public static void main(String[] args) throws Exception {
        int N = 1000-Integer.parseInt(br.readLine()), answer = 0;
        for(int i:coin){
            for(;N>=i;N-=i) answer++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}