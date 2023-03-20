import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t = 0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            if(k%2==1){
                bw.write(s%2==0?"0\n":"1\n");
            }else{
                s%=k+1;
                bw.write(s==k?String.format("%d\n",k):(s%2==0?"0\n":"1\n"));
            }
        }
        bw.flush();
    }
}