import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for(int i=0;i<n;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, (e1, e2)->{
        	if(e1[1]==e2[1]) {
        		return e1[0]-e2[0];
        	}else {
        		return e1[1]-e2[1];
        	}
        });
        for(int i=0;i<n;i++) {
        	sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}