import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
	        ArrayList<Integer>[] outs = new ArrayList[n+1];
	        for(int i=1;i<n+1;i++){
	            outs[i] = new ArrayList<>();
	        }
	        Queue<Integer> q = new LinkedList<>();
	        int[] ins = new int[n+1];
	        int[] cost = new int[n+1];
	        int[] total = new int[n+1];
            st = new StringTokenizer(br.readLine());
	        for(int i=1;i<=n;i++){
	            cost[i] = Integer.parseInt(st.nextToken());
	        }
	        for(int i=0;i<m;i++){
	            st = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
	            ins[b]++;
	            outs[a].add(b);
	        }
	        for(int i=1;i<=n;){
	            for(int j=1;j<=n;j++){
	                if(ins[j]==0){
	                    total[j]+=cost[j];
	                    q.add(j);
	                    ins[j]--;
	                    i++;
	                    while(!outs[j].isEmpty()){
	                    	int num = outs[j].remove(0);
	                        ins[num]--;
	                        total[num]=Math.max(total[num], total[j]);
	                    }
	                    break;
	                }
	            }
	        }
	        sb.append(total[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}