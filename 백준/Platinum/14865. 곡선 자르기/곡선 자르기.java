import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static class Cross implements Comparable<Cross>{
		int pos, idx; // x좌표 pos, 몇 번째로 x축과 교차하는 지 idx
		boolean up; //아래에서 위로 올라가는 선이면 true
		public Cross(int pos, int idx, boolean up) {
			this.pos = pos;
			this.idx = idx;
			this.up = up;
		}
		@Override
		public int compareTo(Cross o) {
			return pos-o.pos;
		}
	}
	public static void main(String[] args) throws Exception{
		PriorityQueue<Cross> pq = new PriorityQueue<>();
		Deque<Integer> stack = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine()), index = 0, total, outs = 0, ins = 0;
		st = new StringTokenizer(br.readLine());
		
		// 입력을 받으면서 y좌표의 부호가 변할 때 마다 PriorityQueue 에 넣어서 x좌표순 정렬해줌
		int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
		int x0 = x1, y0 = y1;
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
			if(y1*y2<0) pq.offer(new Cross(x2,index++,y1<y2));
			x1 = x2;
			y1 = y2;
		}
		if(y1*y0<0) pq.offer(new Cross(x0,index++,y1<y0)); // 마지막 -> 처음으로 돌아가는 선
		
		
		// 루프 안에서 이전 인덱스와 비교하기 위해 맨 처음 원소를 뽑아 저장하고 스택에 추가해줌
		total = pq.size();
		int idx = pq.poll().idx;
		stack.addLast(idx);
		
		while(!pq.isEmpty()) {
			Cross nc = pq.poll();
			int nidx = nc.idx;
			
			// 바로 왼쪽의 인덱스랑 비교해서 올라오는 쪽보다 내려가는 쪽이 1 크다면
			// 안에 아무것도 들어있지 않은 봉우리 
			if(nc.up&&((nidx+1)%total==idx)) ins++;
			else if(!nc.up&&((idx+1)%total==nidx)) ins++;
			
			// 스택의 맨 첫 번째랑 비교
			if(!stack.isEmpty()) {
				int sidx = stack.peekFirst();
				// 스택의 맨 처음 인덱스와 비교해서 올라오는 쪽보다 내려가는 쪽이 1 크다면
				// 밖에 아무것도 감싸고 있지 않은 봉우리 
				if((nc.up&&((nidx+1)%total==sidx))||(!nc.up&&((sidx+1)%total==nidx))) {
					outs++;
					stack.clear();
					//해당되지 않으면 지금 인덱스는 스택에 추가
				}else stack.addLast(nidx);
			}//해당되지 않으면 지금 인덱스는 스택에 추가
			else stack.addLast(nidx);
			
			idx = nidx;
		}
		
		// 정답 출력
		bw.write(Integer.toString(outs));
		bw.write(" ");
		bw.write(Integer.toString(ins));
		bw.flush();
	}
}