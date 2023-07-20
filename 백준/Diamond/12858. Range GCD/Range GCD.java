import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static class SegmentTree{
        long[] tree, lazy, diff;
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));
            this.treeSize = (int) Math.pow(2,h+1);
            tree = new long[treeSize];
            lazy = new long[treeSize];
            diff = new long[treeSize];
        }
        public long init(long[] arr, int node, int start,int end){
            if(start == end){
                return tree[node] = arr[start];
            }
            return tree[node] =init(arr,node<<1,start,(start+ end)/2) + init(arr,(node<<1)+1,(start+end)/2+1,end);
        }
        public long setDiff(int node, int start, int end, int idx, long val){
            if(idx<start||end<idx) return diff[node];
            if(start==end) return diff[node]+=val;
            return diff[node] = gcd(setDiff(node<<1,start,(start+ end)/2,idx,val),setDiff((node<<1)+1,(start+end)/2+1,end,idx,val));
        }
        public long getGcd(int node, int start, int end, int left, int right){
            if(left>right) return 0;
            if(left==start&&right==end) return diff[node];
            return gcd(getGcd(node<<1,start,(start+ end)/2,left,Math.min(right,(start+ end)/2)),getGcd((node<<1)+1,(start+ end)/2+1,end,Math.max((start+ end)/2+1,left),right));
        }
        public void lazyUpdate(int node, int start, int end, int left, int right, long diff){
            if(right < start || end < left) return;
            if(left<=start&&end<=right){
                lazy[node]+=diff;
                return;
            }
            tree[node] += diff*(Math.min(end,right)-Math.max(start,left)+1);
            lazyUpdate(node<<1, start, (start+end)/2, left, right, diff);
            lazyUpdate((node<<1)+1, (start+end)/2+1, end, left,right, diff);
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
            return sum(node<<1, start, (start+end)/2, left, right)+
                    sum((node<<1)+1, (start+end)/2+1, end, left, right);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n+1];
        SegmentTree segTree = new SegmentTree(n);
        st = new StringTokenizer(br.readLine());
        nums[1] = Long.parseLong(st.nextToken());
        for(int i=2;i<=n;i++) segTree.setDiff(1,1,n,i,(nums[i]=Long.parseLong(st.nextToken()))-nums[i-1]);
        segTree.init(nums,1,1,n);
        for(int i= Integer.parseInt(br.readLine()), cmd, l, r;i>0;i--) {
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            if(cmd==0){
                sb.append(Math.abs(l==r?segTree.sum(1,1,n,l,l):gcd(segTree.sum(1,1,n,l,l),segTree.getGcd(1,1,n,l+1,r)))).append('\n');
            }else{
                segTree.lazyUpdate(1,1,n,l,r,cmd);
                segTree.setDiff(1,1,n,l,cmd);
                segTree.setDiff(1,1,n,r+1,-cmd);
            }
        }
        System.out.println(sb);
    }

    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}