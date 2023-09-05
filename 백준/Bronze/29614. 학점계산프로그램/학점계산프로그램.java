import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int sum = 0, cnt = 0;
        for(char ch:br.readLine().toCharArray()){
            if(ch=='+') sum++;
            else{
                sum+=2*"FDCBA".indexOf(ch);
                cnt++;
            }
        }
        bw.write(Double.toString(0.5*sum/cnt));
        bw.flush();
    }
}