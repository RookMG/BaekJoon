import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
        int time = 0, position = 0;
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int d = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken());
        	time += d-position;
        	position = d;
        	int cycleTime = time%(r+g);
        	time += cycleTime<r?r-cycleTime:0;
        }
        time+=l-position;
        System.out.println(time);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}