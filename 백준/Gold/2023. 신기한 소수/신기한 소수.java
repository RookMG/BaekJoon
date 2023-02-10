import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public boolean prime(int num) {
    	if(num==1) return false;
    	if(num==2) return true;
    	for(int i=2;i<=1+(int)Math.sqrt(num);i++) {
    		if(num%i==0) {
    			return false;
    		}
    	}
    	return true;
    }
	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), compare = (int)Math.pow(10, n-1);    
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(2);q.offer(3);q.offer(5);q.offer(7);
        while(!q.isEmpty()) {
        	int now = q.poll();
        	if(!prime(now))continue;
        	if(now<compare) {
        		for(int i=1;i<10;i+=2) {
        			q.offer(now*10+i);
        		}
        	}else{
        		sb.append(now).append("\n");
        	}
        }
        System.out.println(sb);
    }                                                 
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}