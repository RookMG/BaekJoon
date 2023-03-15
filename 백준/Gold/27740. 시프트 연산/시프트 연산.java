import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int answer, n, s;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        answer = n;
        s = 0;
        for(int i=0;i<n;i++) sb.append("L");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            if(Integer.parseInt(st.nextToken())==1){
                if(s!=0) {
                    update(i);
                    s = 0;
                }
                continue;
            }
            s++;
        }
        if(s!=0) update(n);
        bw.write(Integer.toString(answer));
        bw.write("\n");
        bw.write(sb.toString());
        bw.flush();
    }
    static void update(int i){
        int left = i - s, right = n - i, size = 0;
        if(left<right){
            size = 2*left + right;
            if(size<answer){
                answer = size;
                sb.setLength(0);
                for(int j=0;j<left;j++){
                    sb.append("L");
                }
                for(int j=0;j<left+right;j++){
                    sb.append("R");
                }
            }
        }
        else{
            size = 2*right+left;
            if (size < answer) {
                answer = size;
                sb.setLength(0);
                for(int j=0;j<right;j++){
                    sb.append("R");
                }
                for(int j=0;j<left+right;j++){
                    sb.append("L");
                }
            }
        }
    }
}