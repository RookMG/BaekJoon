import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int[][] link = {{0,1},{2,3},{0,2},{1,2},{2,4},{0,3},{1,4},{0,5},{3,5},{4,5},{1,5},{3,4}};
    static int[] line = new int[6];
    static char[] ans = new char[12];
    static boolean found = false;
    public static void main(String[] args) throws Exception {
        for(int i=0, pos = 0;i<5;i++) {
            st = new StringTokenizer(br.readLine(), ".");
            while(st.hasMoreTokens()){
                char now = st.nextToken().charAt(0);
                ans[pos++] = now=='x'?64:now;
            }
        }
        int visit = 0;
        for(int i=0;i<12;i++){
            line[link[i][0]]+=ans[i]-64;
            line[link[i][1]]+=ans[i]-64;
            if(ans[i]!=64) visit |= 1<<(ans[i]-65);
        }
        recur(visit);
        bw.write(String.format("....%c....\n.%c.%c.%c.%c.\n..%c...%c..\n.%c.%c.%c.%c.\n....%c....",ans[0],ans[1],ans[2],ans[3],ans[4],ans[5],ans[6],ans[7],ans[8],ans[9],ans[10],ans[11]));
        bw.flush();
    }
    static void recur(int visit){
        if(found) return;
        if(visit == (1<<12)-1){
            for(int i:line){
                if(i!=26) return;
            }
            found = true;
            return;
        }
        int pos = 0;
        while(ans[pos]!=64) pos++;
        for(int i=0;i<12;i++){
            if((visit&(1<<i))!=0) continue;
            ans[pos] = (char) (65+i);
            line[link[pos][0]]+=ans[pos]-64;
            line[link[pos][1]]+=ans[pos]-64;
            recur(visit|(1<<i));
            if(found) return;
            line[link[pos][0]]-=ans[pos]-64;
            line[link[pos][1]]-=ans[pos]-64;
            ans[pos] = 64;
        }
    }
}