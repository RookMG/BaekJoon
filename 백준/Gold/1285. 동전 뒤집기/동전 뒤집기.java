import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] map;
    static int N, ans=400;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        for(int i=0;i<N;i++){
            for(char ch: br.readLine().toCharArray()){
                map[i]<<=1;
                map[i] += ch=='T'?1:0;
            }
        }
        for(int i=(1<<N)-1, now, cnt;i>=0;i--){
            now = 0;
            for(int line:map) {
                cnt = Integer.bitCount(i^line);
                now += Math.min(cnt,N-cnt);
            }
            ans = Math.min(ans,now);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}