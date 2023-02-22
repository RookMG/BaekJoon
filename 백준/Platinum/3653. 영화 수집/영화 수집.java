import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m =Integer.parseInt(st.nextToken());
			long[] tower = new long[1+n+m];
			int[] index = new int[1+n];
			for(int i=1;i<=n;i++) tower[index[i] = m+i] = 1;
			SegmentTree tree = new SegmentTree(1+n+m);
			tree.init(tower,1,1,n+m);
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++){
				int num = Integer.parseInt(st.nextToken());
				bw.write(Long.toString(tree.sum(1,1,n+m,1,index[num]-1)));
				tree.update(1,1,n+m,index[num],-1);
				index[num] = m-i;
				tree.update(1,1,n+m,index[num],1);
				bw.write(" ");
			}
			bw.write("\n");
		}
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
		public long init(long[] arr, int node, int start, int end){
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