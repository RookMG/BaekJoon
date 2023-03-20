import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int g = 0;
        for(int i=0;i<2;i++){
            int num = Integer.parseInt(st.nextToken());
            for(int l = 1;;l<<=1){
                if((l&num)!=0){
                    g^=l;
                    break;
                }
            }
        }
        bw.write(g==0?"B player wins":"A player wins");
        bw.flush();
    }
}