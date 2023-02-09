import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] req;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), size = Integer.parseInt(st.nextToken()), answer = 0;
        int[] line = new int[n];
        char[] data = br.readLine().toCharArray();
        for(int i = 0;i<n;i++) {
        	line[i] = "ACGT".indexOf(data[i]);
        }
        req = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
        	req[i] -= Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<size;i++) {
        	req[line[i]]++;
        }
        answer+=valid();
        for(int i=0;i<n-size;i++) {
        	req[line[i+size]]++;
        	req[line[i]]--;
            answer+=valid();
        }
        System.out.println(answer);
    }
    static int valid() {
    	int v = 1;
    	for(int i=0;i<4;i++) {
    		if(req[i]<0) {
    			v = 0;
    			break;
    		}
    	}
    	return v;
    }
}