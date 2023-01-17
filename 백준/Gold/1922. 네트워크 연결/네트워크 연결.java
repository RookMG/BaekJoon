import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] parent;
	static int findParent(int i) {
		return parent[i]==i?parent[i]:(parent[i]=findParent(parent[i]));
	}
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine()), e = Integer.parseInt(br.readLine()), answer = 0;
        parent = new int[v+1];
        for(int i=0;i<=v;i++) {
        	parent[i]=i;
        }
        int[][] links = new int[e][3];
        for(int i=0;i<e;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<3;j++) {
        		links[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        Arrays.sort(links,(e1,e2) ->{
        	return e1[2]-e2[2];
        });
        for(int[] l:links) {
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