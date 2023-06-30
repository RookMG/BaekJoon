import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer buf = new StringBuffer();
    static String target;
    static char ans = '0';
    public static void main(String[] args) throws Exception {
        target = br.readLine();
        recur(br.readLine());
        bw.write(ans);
        bw.flush();
    }
    static void recur(String now){
        if(ans == '1') return;
        if(now.length() == target.length()){
            if(now.equals(target)) ans = '1';
            return;
        }
        if(now.charAt(now.length()-1)=='A') recur(now.substring(0,now.length()-1));
        if(now.charAt(0)=='B'){
            buf.setLength(0);
            buf.append(now.substring(1));
            recur(buf.reverse().toString());
        }
    }
}