import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] line, key;
    static int[] pi, dp;
    static ArrayList<ArrayList<Integer>> pos;
    public static void main(String[] args) throws Exception{
        line = br.readLine().toCharArray();
        pos = new ArrayList<>();
        dp = new int[line.length+1];
        for(int i=0;i<line.length;i++) pos.add(new ArrayList<>());
        for(int i= Integer.parseInt(br.readLine());i>0;i--){
            key = br.readLine().toCharArray();
            pi = new int[key.length];
            getPi();
            kmp();
        }
        for(int i=0;i<line.length;i++) {
            dp[i+1] = Math.max(dp[i+1],dp[i]);
            for(int l:pos.get(i)) dp[i+l] = Math.max(dp[i+l],dp[i]+l);
        }
        bw.write(line.length==dp[line.length]?'1':'0');
        bw.flush();
    }
    static void getPi(){
        for(int i=1,j=0;i<pi.length;i++){
            while(j>0&&key[i]!=key[j]) j = pi[j-1];
            if(key[i]==key[j]) pi[i] = ++j;
        }
    }
    static void kmp(){
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j]) j=pi[j-1];
            if(line[i]!=key[j]) continue;
            if(j==key.length-1){
                pos.get(i-j).add(key.length);
                j = pi[j];
                continue;
            }
            j++;
        }
    }
}