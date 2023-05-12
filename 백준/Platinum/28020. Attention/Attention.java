import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long answer = 0L;
        int[] index = new int[N], order = new int[N];
        long[] lsum = new long[N], rsum = new long[N];
        SegmentTree left = new SegmentTree(N), right = new SegmentTree(N);
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            index[Integer.parseInt(st.nextToken())] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            order[i] = index[Integer.parseInt(st.nextToken())]+1;
        }
        for(int i=0;i<N;i++){
            lsum[i] = left.sum(1,1,N,1,order[i]-1);
            rsum[N-1-i] = right.sum(1,1,N,order[N-1-i]+1,N);
            left.update(1,1,N,order[i],1);
            right.update(1,1,N,order[N-1-i],1);
        }
        for(int i=0;i<N;i++){
            answer += lsum[i]*rsum[i];
        }
        bw.write(answer==0?"Attention is what I want":"My heart has gone to paradise\n");
        if(answer!=0) bw.write(Long.toString(answer));
        bw.flush();
    }

    static class SegmentTree{
        long tree[];
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
        }
        public void update(int node, int start, int end, int idx, long diff){
            if(idx < start || end < idx) return;
            tree[node] += diff;
            if(start != end){
                update(node*2, start, (start+end)/2, idx, diff);
                update(node*2+1, (start+end)/2+1, end, idx, diff);
            }
        }
        public long sum(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 0;
            }
            if(left <= start && end <= right){
                return tree[node];
            }
            return sum(node*2, start, (start+end)/2, left, right)+
                    sum(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
}