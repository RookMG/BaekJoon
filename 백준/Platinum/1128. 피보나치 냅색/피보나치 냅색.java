import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long[][] inputs, sums;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        inputs = new long[N][2];
        sums = new long[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Long.parseLong(st.nextToken());
            inputs[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(inputs, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0]==o2[0]) return Long.compare(o1[1],o2[1]);
                return Long.compare(o1[0],o2[0]);
            }
        });
        sums[0][0] = inputs[0][0];
        sums[0][1] = inputs[0][1];
        for(int i=1;i<N;i++){
            sums[i][0] += sums[i-1][0] + inputs[i][0];
            sums[i][1] += sums[i-1][1] + inputs[i][1];
        }
        bw.write(Long.toString(recur(N-1,Long.parseLong(br.readLine()),false)));
        bw.flush();
    }
    static long recur(int idx, long weight, boolean sameW){
        if(idx<0) return 0L;
        if(sums[idx][0] <= weight) return sums[idx][1];
        if(inputs[idx][0]<=weight && (!sameW || inputs[idx+1][0] != inputs[idx][0])) return Math.max(recur(idx-1,weight-inputs[idx][0], false)+inputs[idx][1],recur(idx-1,weight,true));
        return recur(idx-1,weight,true);
    }
}