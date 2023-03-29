import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public void solution() throws Exception {
		int n = Integer.parseInt(br.readLine());
		long[] nums = new long[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		SegmentTree segTree = new SegmentTree(n);
		segTree.init(nums,1,1,n);
		ArrayDeque<int[]> updates = new ArrayDeque<>();
		ArrayList<long[]> sums = new ArrayList<>();
		int idx = 0;
		for(int i = Integer.parseInt(br.readLine());i>0;i--) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().charAt(0)=='1') updates.offerLast(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			else sums.add(new long[]{idx++,0,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		Collections.sort(sums, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[2],o2[2]);
			}
		});
		idx = 0;
		for(long[] sum : sums){
			for(;sum[2]>idx;idx++){
				int[] update = updates.pollFirst();
				segTree.update(1,1,n,update[0],update[1]-nums[update[0]]);
				nums[update[0]] = update[1];
			}
			sum[1] = segTree.sum(1,1,n,(int)sum[3],(int)sum[4]);
		}
		Collections.sort(sums, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0],o2[0]);
			}
		});
		for(long[] sum : sums){
			sb.append(sum[1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
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