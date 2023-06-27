import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int R, C;
    static int[] map;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R*C];
        for(int r=0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<C;c++) map[r*C+c] = Integer.parseInt(st.nextToken());
        }
        BitSet adj = new BitSet(R*C), all = new BitSet(R*C);
        adj.set(0);
        all.set(1,R*C);
        long ans = recur(0,adj,all);
        for(int i=1;i<R*C;i++){
            adj.clear(i-1);
            adj.set(i);
            all.clear(i);
            ans+=recur(0,adj,all);
        }
        bw.write(Long.toString(ans));
        bw.flush();
    }
    static long recur(int score, BitSet adj, BitSet all){
        long ret = score;
        for(int i=0;i<R*C;i++){
            i = adj.nextSetBit(i);
            if(i==-1) break;
            adj.clear(i);
            BitSet adjNext = (BitSet)adj.clone(), allNext = (BitSet)all.clone();
            if(i%C!=0&&all.get(i-1)){
                allNext.clear(i-1);
                adjNext.set(i-1);
            }
            if(i%C!=C-1&&all.get(i+1)){
                allNext.clear(i+1);
                adjNext.set(i+1);
            }
            if(i/C!=0&&all.get(i-C)){
                allNext.clear(i-C);
                adjNext.set(i-C);
            }
            if(i/C!=R-1&&all.get(i+C)){
                allNext.clear(i+C);
                adjNext.set(i+C);
            }
            ret += recur(score^map[i],adjNext,allNext);
        }
        return ret;
    }
}