import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        SegmentTree segTree = new SegmentTree(n);
        segTree.init(nums,1,1,n);
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            if(a==1) {
                nums[b]=c;
                segTree.update(1,1,n,b,c);
            }else if(a==2){
                sb.append(c-b+1-segTree.findOdd(1,1,n,b,c)).append("\n");
            }else{
                sb.append(segTree.findOdd(1,1,n,b,c)).append("\n");
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    static class SegmentTree{
        int[] odd;
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

            this.treeSize = (int) Math.pow(2,h+1);
            odd = new int[treeSize];
        }
        public int init(int[] arr, int node, int start,int end){
            if(start == end){
                return odd[node] = arr[start]%2;
            }
            int left = init(arr,node*2,start,(start+ end)/2), right = init(arr,node*2+1,(start+end)/2+1,end);
            return odd[node] = left+right;
        }

        public void update(int node, int start, int end, int idx, int val){
            if(idx > end || idx < start){
                return;
            }
            if(start==end){
                odd[node] = val%2;
                return;
            }
            update(node*2,start,(start+end)/2,idx,val);
            update(node*2+1,(start+end)/2+1,end,idx,val);
            odd[node] = odd[node*2]+odd[node*2+1];
        }
        public int findOdd(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 0;
            }
            if(left <= start && end <= right){
                return odd[node];
            }
            return findOdd(node*2, start, (start+end)/2, left, right)+findOdd(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
}