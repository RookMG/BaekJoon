import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1], greedy = new int[n+1];
        for(int i=1;i<=n;i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        greedy[1] = arr[1];
        if(n>1) {
        	greedy[2] = arr[1]+arr[2];
        }
        for(int i=3;i<=n;i++) {
        	greedy[i] = Math.max(greedy[i-1], Math.max(greedy[i-2]+arr[i],greedy[i-3]+arr[i-1]+arr[i]));
        }
        
        System.out.println(greedy[n]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}