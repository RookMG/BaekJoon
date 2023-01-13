import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++)
        	sb.append(" ");
		sb.append("*").append("\n");
        for(int i=1;i<n;i++) {
        	for(int j=1;j<n-i;j++)
        		sb.append(" ");
    		sb.append("*");
        	for(int j=0;j<2*i-1;j++)
        		sb.append(" ");
    		sb.append("*");
    		sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}