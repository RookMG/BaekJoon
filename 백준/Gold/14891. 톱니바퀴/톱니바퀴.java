import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] gears = new char[4][];
    static boolean[][] link = {{false,false},{false,false},{false,false},{false,false}};
    public static void main(String[] args) throws Exception{
        for(int i=0;i<4;i++) gears[i] = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine()),answer = 0;
        for(int r=0;r<n;r++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1, dir = Integer.parseInt(st.nextToken());
            for(int i=0;i<3;i++){
                link[i][1]=link[i+1][0]= (gears[i][2]!=gears[i+1][6]);
            }
            //rotate
            rotate(idx,dir);
            int nidx = idx, ndir = dir;
            while(link[nidx][0]){
                nidx--;
                ndir*=-1;
                rotate(nidx,ndir);
            }
            nidx = idx; ndir = dir;
            while(link[nidx][1]){
                nidx++;
                ndir*=-1;
                rotate(nidx,ndir);
            }
        }
        for(int i=0;i<4;i++){
            answer+=(gears[i][0]-'0')*(1<<i);
        }
        System.out.print(answer);
    }
    static void rotate(int idx, int dir){
        char[] tmp = new char[8];
        for(int i=0;i<8;i++){
            tmp[i] = gears[idx][(8+i-dir)%8];
        }
        gears[idx] = tmp;
    }
}