import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static final int MAX_VALUE = 500001;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine()), ans = 0;
        int[][] student = new int[N+1][3];
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) student[Integer.parseInt(st.nextToken())][i] = j;
        }
        Arrays.sort(student, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        SegmentTree segTree = new SegmentTree(N);
        segTree.init(1,1,N);
        for(int i=1, q;i<=N;i++){
            q = segTree.findMin(1,1,N,1,student[i][1]);
            if(q>student[i][2]) ans++;
            segTree.update(1,1,N,student[i][1],student[i][2]);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    static class SegmentTree{
        int min[];
        int treeSize;
        public SegmentTree(int arrSize){
            int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));
            this.treeSize = (int) Math.pow(2,h+1);
            min = new int[treeSize];
        }
        public int init(int node, int start,int end){
            if(start == end){
                return min[node] = MAX_VALUE;
            }
            return min[node] = Math.min(init(node*2,start,(start+ end)/2), init(node*2+1,(start+end)/2+1,end));
        }
        public int findMin(int node, int start, int end, int left, int right){
            if(left > end || right < start){
                return 1000000001;
            }
            if(left <= start && end <= right){
                return min[node];
            }
            return Math.min(findMin(node*2, start, (start+end)/2, left, right), findMin(node*2+1, (start+end)/2+1, end, left, right));
        }
        public void update(int node, int start, int end, int idx, int val){
            if(idx < start || end < idx) return;
            min[node] = Math.min(min[node],val);
            if(start != end){
                update(node*2, start, (start+end)/2, idx, val);
                update(node*2+1, (start+end)/2+1, end, idx, val);
            }
        }
    }
}