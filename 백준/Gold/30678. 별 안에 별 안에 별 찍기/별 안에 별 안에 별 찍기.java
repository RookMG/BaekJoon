import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static final boolean[][] star = {{false,false,true,false,false},{false,false,true,false,false},{true,true,true,true,true},{false,true,true,true,false},{false,true,false,true,false}};
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> now = new ArrayList<>(), next = new ArrayList<>(), tmp;
        now.add("*");
        for(int i=1, size = 1;i<=N;i++, size*=5){
            next.clear();
            sb.setLength(0);
            for(int j=0;j<size;j++) sb.append(' ');
            String blank = sb.toString();
            for(int r=0;r<5;r++){
                for(int j=0;j<size;j++) {
                    sb.setLength(0);
                    for (int c = 0; c < 5; c++) sb.append(star[r][c]?now.get(j):blank);
                    next.add(sb.toString());
                }
            }
            tmp = next;
            next = now;
            now = tmp;
        }
        sb.setLength(0);
        for(String s:now) sb.append(s).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}