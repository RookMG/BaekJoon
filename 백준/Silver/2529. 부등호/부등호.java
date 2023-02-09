import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int n;
    static boolean found;
    static boolean[] asc;
    static boolean[] used = new boolean[10];
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        asc = new boolean[n];
        arr = new int[n+1];
        String line = br.readLine();
        for(int i = 0;i<n;i++) {
        	asc[i] = (line.charAt(2*i)=='<');
        }
        found = false;
        findTop(0);
        found = false;
        findBot(0);
        System.out.print(sb);
    }
    static void findTop(int k) {
    	if(k==n+1) {
    		if(!found) {
    			found = true;
    			for(int i:arr) {
    				sb.append(i);
    			}
				sb.append("\n");
    		}
    		return;
    	}
    	for(int i=9;i>=0;i--) {
    		if(!used[i]) {
    			if(k==0||(i>arr[k-1]==asc[k-1])) {
    				arr[k] = i;
    				used[i] = true;
    				findTop(k+1);
    				used[i] = false;
    			}
    		}
    	}
    }
    static void findBot(int k) {
    	if(k==n+1) {
    		if(!found) {
    			found = true;
    			for(int i:arr) {
    				sb.append(i);
    			}
				sb.append("\n");
    		}
    		return;
    	}
    	for(int i=0;i<10;i++) {
    		if(!used[i]) {
    			if(k==0||(i>arr[k-1]==asc[k-1])) {
    				arr[k] = i;
    				used[i] = true;
    				findBot(k+1);
    				used[i] = false;
    			}
    		}
    	}
    }
}