import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int ans = 0;
        char[] line = br.readLine().toCharArray();
        for(int i=0;i<=line.length-4;i++){
            if(line[i]=='D'&&line[i+1]=='K'&&line[i+2]=='S'&&line[i+3]=='H') ans++;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}