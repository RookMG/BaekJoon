import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] points, cpy;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        points = new int[n][2];
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	points[i][0] = Integer.parseInt(st.nextToken());
        	points[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
        });
        System.out.print(find(0,n-1));
    }
    static int find(int left, int right){
    	if(left>=right) return Integer.MAX_VALUE;
    	if(right-left==1) return (points[left][0]-points[right][0])*(points[left][0]-points[right][0])+(points[left][1]-points[right][1])*(points[left][1]-points[right][1]);
    	int min = Math.min(find(left,left+(right-left)/2),find(left+(right-left)/2+1,right)), lidx = left+(right-left)/2, ridx = left+(right-left)/2+1, llen=lidx, rlen=ridx;
    	while(llen>=left&&min>(points[lidx][0]-points[llen][0])*(points[lidx][0]-points[llen][0])) {llen--;} llen++;
    	while(rlen<=right&&min>(points[ridx][0]-points[rlen][0])*(points[ridx][0]-points[rlen][0])) {rlen++;} rlen--;
    	cpy = Arrays.copyOfRange(points,llen,rlen+1);
    	Arrays.sort(cpy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
        });
    	for(int i=0;i<rlen-llen;i++) {
    		for(int j=i+1;j<=rlen-llen;j++) {
    			if(min<(cpy[i][1]-cpy[j][1])*(cpy[i][1]-cpy[j][1])) break;
    			min = Math.min(min,(cpy[i][0]-cpy[j][0])*(cpy[i][0]-cpy[j][0])+(cpy[i][1]-cpy[j][1])*(cpy[i][1]-cpy[j][1]));
    		}
    	}
    	return min;
    }
}