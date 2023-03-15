import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        for(int c=0;c<C;c++){
            for(int b=0;b<B;b++){
                s1.append(c%2==0?'X':'.');
                s2.append(c%2==0?'.':'X');
            }
        }
        s1.append("\n");
        s2.append("\n");
        for(int r=0;r<R;r++){
            for(int a=0;a<A;a++){
                bw.write(r%2==0?s1.toString():s2.toString());
            }
        }
        bw.flush();
    }
}