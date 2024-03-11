import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken())-1;
        for(int i=0;;i++){
            if(i%15==a&&i%28==b&&i%19==c){
                bw.write(Integer.toString(i+1));
                break;
            }
        }
        bw.flush();
    }
}