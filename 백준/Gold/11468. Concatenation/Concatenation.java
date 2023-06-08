import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        char[] pre = br.readLine().toCharArray(), sub = br.readLine().toCharArray();
        long[] pcnt = new long[26], scnt = new long[26];
        long ans = 1L*pre.length*sub.length;
        for(int i=1;i<pre.length;i++) pcnt[pre[i]-'a']++;
        for(int i=0;i<sub.length-1;i++) scnt[sub[i]-'a']++;
        for(int i=0;i<26;i++) ans-=pcnt[i]*scnt[i];
        bw.write(Long.toString(ans));
        bw.flush();
    }
}