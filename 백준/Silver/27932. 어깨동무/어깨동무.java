import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        if(n==1){
            bw.write("0");
            bw.flush();
            System.exit(0);
        }
        st = new StringTokenizer(br.readLine());
        int[] heights = new int[n], score = new int[n];
        for(int i=0;i<n;i++) heights[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<n-1;i++) score[i] = Math.max(Math.abs(heights[i]-heights[i-1]),Math.abs(heights[i]-heights[i+1]));
        score[0] = Math.abs(heights[1]-heights[0]);
        score[n-1] = Math.abs(heights[n-2]-heights[n-1]);
        Arrays.sort(score);
        bw.write(Integer.toString(n==k?0:score[n-k-1]));
        bw.flush();
    }
}