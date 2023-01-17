import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] outs = new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            outs[i] = new ArrayList<>();
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ins = new int[n+1];
        int[] cost = new int[n+1];
        int[] total = new int[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            for(int k=0;k<j;k++) {
            	ins[i]++;
            	outs[Integer.parseInt(st.nextToken())].add(i);
            }
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
        Arrays.sort(total);
        sb.append(total[total.length-1]).append("\n");
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}