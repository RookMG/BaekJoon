// https://en.wikipedia.org/wiki/Eight_queens_puzzle
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        switch(N%6){
            case 2:
                for(int i=2;i<=N;i+=2) sb.append(i).append('\n');
                sb.append(3).append('\n');
                sb.append(1).append('\n');
                for(int i=7;i<=N;i+=2) sb.append(i).append('\n');
                sb.append(5).append('\n');
                break;
            case 3:
                for(int i=4;i<=N;i+=2) sb.append(i).append('\n');
                sb.append(2).append('\n');
                for(int i=5;i<=N;i+=2) sb.append(i).append('\n');
                sb.append(1).append('\n');
                sb.append(3).append('\n');
                break;
            default:
                for(int i=2;i<=N;i+=2) sb.append(i).append('\n');
                for(int i=1;i<=N;i+=2) sb.append(i).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}