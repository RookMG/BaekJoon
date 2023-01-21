import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        long[] nums = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        SegmentTree segTree = new SegmentTree(n);
        segTree.init(nums,1,1,n);
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            sb.append(segTree.sum(1,1,n,Math.min(a,b),Math.max(a,b))).append("\n");
            segTree.update(1,1,n,c,d-nums[c]);
            nums[c] = d;
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    static class SegmentTree{
        long tree[];
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
        }
        public long init(long[] arr, int node, int start,int end){
            if(start == end){
                return tree[node] = arr[start];
            }
            return tree[node] =init(arr,node*2,start,(start+ end)/2) + init(arr,node*2+1,(start+end)/2+1,end);
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