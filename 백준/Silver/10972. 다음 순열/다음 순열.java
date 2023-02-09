import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        //if(n==1) {System.out.println(-1);return;}
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        find(n-2);
        System.out.print(sb);
    }
    static void find(int k) {
    	if(k==-1) {
    		sb.append(-1);
    		return;
    	}
    	if(arr[k]<arr[k+1]) {
    		for(int i=0;i<(n-1-k)/2;i++) {
    			int tmp = arr[n-1-i];
    			arr[n-1-i] = arr[k+1+i];
    			arr[k+1+i] = tmp;
    		}
    		for(int i=k+1;i<n;i++) {
    			if(arr[k]<arr[i]) {
    				int tmp = arr[k];
    				arr[k] = arr[i];
    				arr[i] = tmp;
    				break;
    			}
    		}
    		print();
    		return;
    	}else {
    		find(k-1);
    	}
    }
    static void print() {
    	for(int i=0;i<n;i++) {
    		sb.append(arr[i]).append(" ");
    	}
    }
}