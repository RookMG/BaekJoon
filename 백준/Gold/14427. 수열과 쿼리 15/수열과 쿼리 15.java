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
            int a = Integer.parseInt(st.nextToken());
            if(a==1) {
                int b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
                nums[b]=c;
                segTree.update(1,1,n,b,c);
            }else{
                sb.append(segTree.totalMin()).append("\n");
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    static class SegmentTree{
        int min[][];
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

            this.treeSize = (int) Math.pow(2,h+1);
            min = new int[treeSize][2];
        }
        public int[] init(int[] arr, int node, int start,int end){
            if(start == end){
                return new int[] {min[node][0] = arr[start],min[node][1] = start};
            }
            int[] left = init(arr,node*2,start,(start+ end)/2), right = init(arr,node*2+1,(start+end)/2+1,end);
            return new int[] {min[node][0] = left[0]<=right[0]?left[0]:right[0], min[node][1] = left[0]<=right[0]?left[1]:right[1]};
        }

        public void update(int node, int start, int end, int idx, int val){
            if(idx > end || idx < start){
                return;
            }
            if(start==end){
                min[node][0] = val;
                min[node][1] = idx;
                return;
            }
            update(node*2,start,(start+end)/2,idx,val);
            update(node*2+1,(start+end)/2+1,end,idx,val);
            min[node] = (min[node*2][0]<=min[node*2+1][0])?min[node*2]:min[node*2+1];
        }
        public int[] findMin(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return new int[]{1000000001,-1};
            }
            if(left <= start && end <= right){
                return min[node];
            }
            int[] lArr = findMin(node*2, start, (start+end)/2, left, right), rArr = findMin(node*2+1, (start+end)/2+1, end, left, right);
            return lArr[0]<=rArr[0]?lArr:rArr;
        }
        public int totalMin(){
            return min[1][1];
        }
    }
}