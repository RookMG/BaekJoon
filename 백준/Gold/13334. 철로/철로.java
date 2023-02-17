import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Comparator<int[]> cmp = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1[0], o2[0]);
		}
	};
    public static void main(String[] args) throws Exception{
    	PriorityQueue<int[]> lq = new PriorityQueue<>(cmp), rq = new PriorityQueue<>(cmp), ln = new PriorityQueue<>(cmp), rn = new PriorityQueue<>(cmp);
        HashSet<Integer> set = new HashSet<>(), dup = new HashSet<>();
    	int n = Integer.parseInt(br.readLine()), answer = 0, d, now;
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	lq.add(new int[] {Integer.parseInt(st.nextToken()),i});
        	rq.add(new int[] {Integer.parseInt(st.nextToken()),i});
        }
        d = Integer.parseInt(br.readLine());
        int min = 0, end;
        int[] tmp;
        while(!lq.isEmpty()||!rq.isEmpty()) { //condition?
        	min = Integer.MAX_VALUE;
        	if(!lq.isEmpty()) min = Math.min(min, lq.peek()[0]);
        	if(!rq.isEmpty()) min = Math.min(min, rq.peek()[0]);
        	if(!ln.isEmpty()) min = Math.min(min, ln.peek()[0]);
        	if(!rn.isEmpty()) min = Math.min(min, rn.peek()[0]);
        	end = min+d;
        	while(!lq.isEmpty()&&(tmp = lq.peek())[0]<=end) {
        		if(set.contains(tmp[1])) dup.add(tmp[1]);
        		else set.add(tmp[1]);
        		ln.add(lq.poll());
        	}
        	while(!rq.isEmpty()&&(tmp = rq.peek())[0]<=end) {
        		if(set.contains(tmp[1])) dup.add(tmp[1]);
        		else set.add(tmp[1]);
        		rn.add(rq.poll());
        	}
        	answer = Math.max(answer,dup.size());
        	if(ln.isEmpty()||rn.isEmpty()) {
        		if(!ln.isEmpty()) {
        			now = ln.poll()[1];
        			dup.remove(now);
        			set.remove(now);
        		}else if(!rn.isEmpty()) {
        			now = rn.poll()[1];
        			dup.remove(now);
        			set.remove(now);
        		}
        	}else {
	        	if(ln.peek()[0]>rn.peek()[0]) {
	        		now = rn.poll()[1];
        			dup.remove(now);
        			set.remove(now);
	        	}else {
	        		now = ln.poll()[1];
        			dup.remove(now);
        			set.remove(now);
	        	}
        	}
        }
        System.out.print(answer);
    }
}