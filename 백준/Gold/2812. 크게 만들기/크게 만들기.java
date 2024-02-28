import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            while(K!=0 && !stack.isEmpty() && stack.peekLast() < s.charAt(i)){
                stack.pollLast();
                K--;
            }
            stack.offerLast(s.charAt(i));
        }
        while(K-->0) stack.pollLast();
        while(!stack.isEmpty()) bw.write(stack.pollFirst());
        bw.flush();
    }
}