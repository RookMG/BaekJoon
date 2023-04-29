import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int before = Integer.parseInt(br.readLine());
        int[] res = {0,0,0};
        for(int i=0;i<3;i++){
            int now = Integer.parseInt(br.readLine());
            res[Integer.compare(before,now)+1]++;
            before = now;
        }
        if(res[1]==3) bw.write("Fish At Constant Depth");
        else if(res[0]==3) bw.write("Fish Rising");
        else if(res[2]==3) bw.write("Fish Diving");
        else bw.write("No Fish");
        bw.flush();
    }
}