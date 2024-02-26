import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine()), cnt = 0;
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(int t=0;t<T;t++){
            dq.clear();
            for(char ch: br.readLine().toCharArray()){
                if(dq.isEmpty()||dq.peekLast()!=ch) dq.offerLast(ch);
                else dq.pollLast();
            }
            if(dq.isEmpty()) cnt++;
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}