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
        int[] nums = new int[n+1];
        for(int i=1;i<=n;i++) {
        	nums[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segTree = new SegmentTree(n);
		segTree.init(nums,1,1,n);
        for(int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        	sb.append(segTree.findMin(1,1,n,a,b)).append(" ").append(segTree.findMax(1,1,n,a,b)).append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
    static class SegmentTree{
        int max[];
        int min[];
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));

            this.treeSize = (int) Math.pow(2,h+1);
            max = new int[treeSize];
            min = new int[treeSize];
        }
        public int[] init(int[] arr, int node, int start,int end){
            if(start == end){
                return new int[] {min[node] = arr[start],max[node] = arr[start]};
            }
            int[] left = init(arr,node*2,start,(start+ end)/2), right = init(arr,node*2+1,(start+end)/2+1,end);
            return new int[] {min[node] = Math.min(left[0], right[0]),max[node] = Math.max(left[1], right[1])};
        }
        public long findMax(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 0;
            }
            if(left <= start && end <= right){
                return max[node];
            }
            return Math.max(findMax(node*2, start, (start+end)/2, left, right), findMax(node*2+1, (start+end)/2+1, end, left, right));
        }
        public long findMin(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 1000000001;
            }
            if(left <= start && end <= right){
                return min[node];
            }
            return Math.min(findMin(node*2, start, (start+end)/2, left, right), findMin(node*2+1, (start+end)/2+1, end, left, right));
        }
    }
}
