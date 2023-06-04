import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] line, key, pi;
    static int l, idx;
    public static void main(String[] args) throws Exception{
        int[][] input = new int[Integer.parseInt(br.readLine())][];
        for(int i=0;i<input.length;i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new int[Integer.parseInt(st.nextToken())-1];
            for(int j=0, before = Integer.parseInt(st.nextToken()), now;j<input[i].length;j++){
                now = Integer.parseInt(st.nextToken());
                input[i][j] = now-before;
                before = now;
            }
        }
        l = Integer.parseInt(br.readLine())-1;
        key = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i=0, before = Integer.parseInt(st.nextToken()), now;i<key.length;i++){
            now = Integer.parseInt(st.nextToken());
            key[i] = now-before;
            before = now;
        }
        for(idx=1;idx<=input.length;idx++){
            line = input[idx-1];
            getPi();
            kmp();
        }
        bw.write(sb.length()==0?"-1":sb.toString());
        bw.flush();
    }
    static void getPi(){
        pi = new int[key.length];
        for(int i=1,j=0;i<key.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
    static void kmp(){
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j])
                j=pi[j-1];
            if(line[i]==key[j]){
                if(j==l-1){
                    sb.append(idx).append(' ');
                    return;
                }else {
                    j++;
                }
            }
        }
    }
}