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
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k =Integer.parseInt(st.nextToken()), idx = k, now;
		int[][] index = new int[n+1][2];
		for(int i=1;i<=n;i++){
			index[i][0] = 1;
			index[i][1] = i;
		}
		SegmentTree tree = new SegmentTree(1+n);
		tree.init(index,1,1,n);
		bw.write("<");
		tree.update(1,1,n,now = tree.find(1,1,n,idx),-1);
		bw.write(Integer.toString(now));
		for(int i=n-1;i>0;i--){
			bw.write(", ");
			idx = (idx+k-2)%i+1;
			tree.update(1,1,n,now = tree.find(1,1,n,idx),-1);
			bw.write(Integer.toString(now));
		}
		bw.write(">");
		bw.flush();
	}

	static class SegmentTree{
		int[][] tree;
		int treeSize;
		public SegmentTree(int arrSize){
			int h = (int) Math.ceil(Math.log(arrSize)/ Math.log(2));
			this.treeSize = (int) Math.pow(2,h+1);
			tree = new int[treeSize][2];
		}
		public int init(int[][] arr, int node, int start, int end){
			if(start == end){
				tree[node][1] = arr[start][1];
				return tree[node][0] = arr[start][0];
			}
			return tree[node][0] =init(arr,node*2,start,(start+ end)/2) + init(arr,node*2+1,(start+end)/2+1,end);
		}
		public void update(int node, int start, int end, int idx, int diff){
			if(idx < start || end < idx) return;
			tree[node][0] += diff;
			if(start != end){
				update(node*2, start, (start+end)/2, idx, diff);
				update(node*2+1, (start+end)/2+1, end, idx, diff);
			}
		}
		public int find(int node, int start, int end, int val){
			if(start == end){
				return tree[node][1];
			}
			int left = tree[node*2][0];
			if(val<=left){
				return find(node*2,start,(start+end)/2,val);
			}else{
				return find(node*2+1,(start+end)/2+1,end,val-left);
			}
		}
		public int count(int node, int start, int end, int left, int right){
			if(left > end || right < start){
				return 0;
			}
			if(left <= start && end <= right){
				return tree[node][0];
			}
			return count(node*2, start, (start+end)/2, left, right)+
					count(node*2+1, (start+end)/2+1, end, left, right);
		}
	}
}