import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), center = 2*n-2;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4*n-3;i++) {
            for(int j=0;j<4*n-3;j++) {
            	sb.append(Math.max(Math.abs(i-center),Math.abs(j-center))%2==0?"*":" ");
            }
    		sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}