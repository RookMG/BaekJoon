import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int key = Integer.parseInt(br.readLine());
        for(char ch:br.readLine().toCharArray()){
            if(ch>='a'&&ch<='z'){
                sb.append((char)((ch-'a'+26-key)%26+'a'));
                key = key%25 + 1;
            }else sb.append(ch);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}