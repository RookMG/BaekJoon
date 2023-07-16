import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int sum = 0, min = 100;
        for(int i=0, now;i<4;i++){
            sum+= now = Integer.parseInt(br.readLine());
            min = Math.min(min,now);
        }
        sum-= min;
        min = 100;
        for(int i=0, now;i<2;i++){
            sum+= now = Integer.parseInt(br.readLine());
            min = Math.min(min,now);
        }
        sum-= min;
        bw.write(Integer.toString(sum));
        bw.flush();
    }
}