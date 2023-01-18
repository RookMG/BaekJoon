import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        LinkedList<int[]> things = new LinkedList<>();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
        	int v = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        	for(int j=k;j>0;j>>=1) {
        		int pack = j - (j>>1);
        		things.offer(new int[] {v*pack, c*pack});
        	}
        }
        int[][] best = new int[things.size()][m+1];
        for(int i=0;i<things.size();i++) {
        	int[] thing = things.get(i);
        	for(int j=0;j<m+1;j++) {
        		if(j>=thing[0]) {
        			best[i][j] = Math.max(i==0?thing[1]:thing[1]+best[i-1][j-thing[0]],i==0?0:best[i-1][j]);
        		}else if(i!=0) {
        			best[i][j] = best[i-1][j];
        		}
        	}
        }
        System.out.println(best[things.size()-1][m]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
