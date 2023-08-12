import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        String s;
        while(!"#".equals(s=br.readLine())){
            int ans = 0;
            for(char c:s.toCharArray()){
                ans <<= 3;
                switch (c){
                    case '\\' : ans+=1; break;
                    case '(' : ans+=2; break;
                    case '@' : ans+=3; break;
                    case '?' : ans+=4; break;
                    case '>' : ans+=5; break;
                    case '&' : ans+=6; break;
                    case '%' : ans+=7; break;
                    case '/' : ans-=1; break;
                }
            }
            sb.append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}