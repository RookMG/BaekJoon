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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] outs = new ArrayList[n+1];
        int[] ins = new int[n+1], value = new int[n+1];
        for(int i=1;i<n+1;i++){
            outs[i] = new ArrayList<>();
            value[i]=1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            ins[b]++;
            outs[a].add(b);
        }
        for(int i=1;i<=n;){
            for(int j=1;j<=n;j++){
                if(ins[j]==0){
                    q.add(j);
                    ins[j]--;
                    i++;
                }
            }
            while(!q.isEmpty()){
                int num = q.poll();
                while(!outs[num].isEmpty()){
                	int tmp = outs[num].remove(0);
                	value[tmp]=Math.max(value[tmp],value[num]+1);
                    ins[tmp]--;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            sb.append(value[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}