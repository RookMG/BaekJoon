import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[] twos = {0,1,5,4};
    static final int[][] threes = {{0,1,2},{0,1,3},{0,2,4},{0,3,4},{1,2,5},{1,3,5},{2,4,5},{3,4,5}};
    public static void main(String[] args) throws Exception {
        long n = Integer.parseInt(br.readLine()), sum = 0, max = 0;
        st = new StringTokenizer(br.readLine());
        long[] nums = new long[6], grd = new long[3];
        for(int i=0;i<6;i++){
            sum+=nums[i] = Integer.parseInt(st.nextToken());
        }
        grd[0] = 50;
        grd[1] = 100;
        grd[2] = 150;
        for(int i=0;i<6;i++){
            grd[0] = Math.min(grd[0],nums[i]);
            max = Math.max(max,nums[i]);
        }
        for(int i=0;i<4;i++){
            grd[1] = Math.min(grd[1], nums[twos[i]]+nums[2]);
            grd[1] = Math.min(grd[1], nums[twos[i]]+nums[3]);
            grd[1] = Math.min(grd[1], nums[twos[i]]+nums[twos[(i+1)%4]]);
            grd[2] = Math.min(grd[2], nums[threes[i][0]]+nums[threes[i][1]]+nums[threes[i][2]]);
            grd[2] = Math.min(grd[2], nums[threes[i+4][0]]+nums[threes[i+4][1]]+nums[threes[i+4][2]]);
        }
        long answer = grd[0]*(5*n*n-16*n+12)+grd[1]*(8*n-12)+grd[2]*4;
        bw.write(Long.toString(n!=1?answer:(sum-max)));
        bw.flush();
    }
}