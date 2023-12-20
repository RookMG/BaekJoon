import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        boolean first;
        if(k>=0){
            first = a!=b;
        }else{
            if(a+b==1) first = false;
            else if(a==b&&a==1) first = true;
            else if(k==-1) first = true;
            else first = a!=b;
        }
        bw.write(first?"First":"Second");
        bw.flush();
    }
}