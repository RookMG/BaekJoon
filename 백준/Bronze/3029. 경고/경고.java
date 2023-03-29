import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine(),":");
        int a = Integer.parseInt(st.nextToken())*3600+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(),":");
        int b = Integer.parseInt(st.nextToken())*3600+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken()) - a;
        if(b<=0)b+=24*60*60;
        bw.write(String.format("%02d:%02d:%02d",b/3600,(b%3600)/60,b%60));
        bw.flush();
    }
}