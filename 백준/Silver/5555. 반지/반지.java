import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        String key = br.readLine(), tmp;
        int ans = 0;
        for(int i= Integer.parseInt(br.readLine());i>0;i--){
            tmp = br.readLine();
            tmp += tmp.substring(0,tmp.length()-1);
            if(tmp.contains(key)) ans++;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}