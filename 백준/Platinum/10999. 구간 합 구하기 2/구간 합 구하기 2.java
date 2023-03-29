import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        long[] nums = new long[n+1];
        for(int i=1;i<=n;i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        SegmentTree segTree = new SegmentTree(n);
        segTree.init(nums,1,1,n);
        for(int i=0;i<m+k;i++) {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().charAt(0)=='1') {
                segTree.lazyUpdate(1,1,n,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Long.parseLong(st.nextToken()));
            }else {
                sb.append(segTree.sum(1,1,n,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))).append("\n");
            }
        }
        System.out.println(sb);
    }
    static class SegmentTree{
        long[] tree, lazy;
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));
            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
            lazy = new long[treeSize];
        }
        public long init(long[] arr, int node, int start,int end){
            if(start == end){
                return tree[node] = arr[start];
            }
            return tree[node] =init(arr,node*2,start,(start+ end)/2) + init(arr,node*2+1,(start+end)/2+1,end);
        }
        public void lazyUpdate(int node, int start, int end, int left, int right, long diff){
            if(right < start || end < left) return;
            if(left<=start&&end<=right){
                lazy[node]+=diff;
                return;
            }
            tree[node] += diff*(Math.min(end,right)-Math.max(start,left)+1);
            lazyUpdate(node*2, start, (start+end)/2, left, right, diff);
            lazyUpdate(node*2+1, (start+end)/2+1, end, left,right, diff);
        }
        public long sum(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 0;
            }
            tree[node] += lazy[node]*(end-start+1);
            if(lazy[node]!=0&&end!=start){
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
            if(left <= start && end <= right){
                return tree[node];
            }
            return sum(node*2, start, (start+end)/2, left, right)+
                    sum(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
}