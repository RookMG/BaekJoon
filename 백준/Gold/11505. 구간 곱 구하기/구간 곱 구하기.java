import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int MOD = 1000000007;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        long[] nums = new long[n+1];
        for(int i=1;i<=n;i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segTree = new SegmentTree(n);
		segTree.init(nums,1,1,n);
        for(int i=0;i<m+k;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        	if(a==1) {
        		segTree.update(1,1,n,b,c);
        		nums[b] = c;
        	}else {
        		sb.append(segTree.mul(1,1,n,b,(int)c)).append("\n");
        	}
        }
        System.out.print(sb);
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
            return tree[node] =(init(arr,node*2,start,(start+ end)/2)*init(arr,node*2+1,(start+end)/2+1,end))%MOD;
        }
        public long update(int node, int start, int end, int idx, long upd){
            if(idx < start || end < idx) return tree[node];
            if(start==end)	return tree[node] = upd;
            return tree[node] = (update(node*2, start, (start+end)/2, idx, upd)*update(node*2+1, (start+end)/2+1, end, idx, upd))%MOD;
        }
        public long mul(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 1;
            }
            if(left <= start && end <= right){
                return tree[node];
            }
            return (mul(node*2, start, (start+end)/2, left, right)*mul(node*2+1, (start+end)/2+1, end, left, right))%MOD;
        }
    }
}
