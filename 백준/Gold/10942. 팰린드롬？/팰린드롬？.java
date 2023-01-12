import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        boolean[][] palin = new boolean[n][n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	palin[i][i] = true;
        }
        for(int i=0;i<n-1;i++) {
        	if(arr[i]==arr[i+1]) {palin[i][i+1] = true;}
        }
        for(int i=2;i<n;i++){
        	for(int j=0;j<n-i;j++) {
        		palin[j][j+i] = (palin[j+1][j+i-1])&&(arr[i+j]==arr[j]);
        	}
        }
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(palin[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]?"1\n":"0\n");
        }
        System.out.println(sb);
        
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}