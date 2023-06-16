import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String line, key;
    static String[] input;
    static int[] pi, dp;
    static boolean[][] fit;
    public static void main(String[] args) throws Exception{
        line = br.readLine();
        dp = new int[line.length()+1];
        pi = new int[10000];
        int N = Integer.parseInt(br.readLine());
        input = new String[N];
        fit = new boolean[N][line.length()];
        for(int i=0;i<N;i++){
            key = input[i] = br.readLine();
            getPi();
            kmp(i);
        }
        for(int i=0;i<line.length();i++) {
            dp[i+1] = Math.max(dp[i+1],dp[i]);
            for(int j=0;j<N;j++) {
                if(!fit[j][i]) continue;
                dp[i+input[j].length()] = Math.max(dp[i+input[j].length()],dp[i]+input[j].length());
            }
        }
        bw.write(line.length()==dp[line.length()]?'1':'0');
        bw.flush();
    }
    static void getPi(){
        Arrays.fill(pi,0);
        for(int i=1,j=0;i<key.length();i++){
            while(j>0&&key.charAt(i)!=key.charAt(j)) j = pi[j-1];
            if(key.charAt(i)==key.charAt(j)) pi[i] = ++j;
        }
    }
    static void kmp(int idx){
        for(int i=0,j=0;i<line.length();i++){
            while(j>0&&line.charAt(i)!=key.charAt(j)) j=pi[j-1];
            if(line.charAt(i)!=key.charAt(j)) continue;
            if(j==key.length()-1){
                fit[idx][i-j] = true;
                j = pi[j];
                continue;
            }
            j++;
        }
    }
}