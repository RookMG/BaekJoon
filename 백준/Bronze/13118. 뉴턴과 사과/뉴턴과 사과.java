import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        int x = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()), answer = 0;
        st = new StringTokenizer(s);
        for(int i=1;st.hasMoreTokens();i++){
            if(Integer.parseInt(st.nextToken())==x){
                answer = i;
                break;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}