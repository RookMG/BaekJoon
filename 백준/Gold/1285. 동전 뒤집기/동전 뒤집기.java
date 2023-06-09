import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 200;
        int[] map = new int[N];
        for(int i=0;i<N;i++){
            for(char ch: br.readLine().toCharArray()) map[i] = (map[i]<<1) + (ch=='T'?1:0);
        }
        for(int i=(1<<N)-1,now=0,cnt;i>=0;i--,ans = Math.min(ans,now),now=0){
            for(int line:map) {
                cnt = Integer.bitCount(i^line);
                now += Math.min(cnt,N-cnt);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}