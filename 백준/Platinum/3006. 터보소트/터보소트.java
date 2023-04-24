import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] position = new int[N+1];
		SegmentTree segTree = new SegmentTree(N);
		for(int i=1;i<=N;i++){
			position[Integer.parseInt(br.readLine())] = i;
		}
		for(int i=1, pos;i<=N;i++){
			if(i%2==1) {
				pos = position[1+(i>>>1)];
				sb.append(pos - 1 - segTree.sum(1, 1, N, 1, pos - 1)).append('\n');
				segTree.update(1, 1, N, pos, 1);
			}else{
				pos = position[N+1-(i>>>1)];
				sb.append(N - pos - segTree.sum(1,1,N,pos+1,N)).append('\n');
				segTree.update(1, 1, N, pos, 1);
			}
		}
		bw.write(sb.toString());
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