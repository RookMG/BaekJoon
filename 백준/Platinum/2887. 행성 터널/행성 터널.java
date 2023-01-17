import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static int[] parent;
	static int findParent(int i) {
		return parent[i]==i?parent[i]:(parent[i]=findParent(parent[i]));
	}
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        parent = new int[v+1];
        int[][] xs = new int[v][2],ys = new int[v][2],zs = new int[v][2];
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int i=0;i<v;i++) {
        	parent[i]=xs[i][1]=ys[i][1]=zs[i][1]=i;
        }
        for(int i=0;i<v;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	xs[i][0] = Integer.parseInt(st.nextToken());
        	ys[i][0] = Integer.parseInt(st.nextToken());
        	zs[i][0] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(xs,(e1,e2) ->{
        	return e1[0]-e2[0];
        });
        Arrays.sort(ys,(e1,e2) ->{
        	return e1[0]-e2[0];
        });
        Arrays.sort(zs,(e1,e2) ->{
        	return e1[0]-e2[0];
        });
        for(int i=1;i<v;i++) {
        	pq.offer(new int[] {xs[i][1],xs[i-1][1],xs[i][0]-xs[i-1][0]});
        	pq.offer(new int[] {ys[i][1],ys[i-1][1],ys[i][0]-ys[i-1][0]});
        	pq.offer(new int[] {zs[i][1],zs[i-1][1],zs[i][0]-zs[i-1][0]});
        }
        while(!pq.isEmpty()){
        	int[] l = pq.poll();
        	int ap = findParent(l[0]), bp = findParent(l[1]);
        	if(ap!=bp) {
        		answer+=l[2];
        		parent[Math.max(ap,bp)]=Math.min(ap,bp);
        	}
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}