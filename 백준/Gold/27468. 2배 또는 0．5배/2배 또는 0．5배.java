import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static boolean found;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n+1];
        arr = new int[n];
        visit[0] = true;
        found = false;
        find(0);
        System.out.print(sb);
    }
    static void find(int len){
        if(found) return;
        if(len==n){
            found = true;
            sb.append("YES").append("\n");
            for(int i=0;i<n;i++)
                sb.append(arr[i]).append(" ");
            return;
        }
        if(len<2){
            for(int i=1;i<=n;i++){
                if(!found&&!visit[i]) {
                    visit[i] = true;
                    arr[len] = i;
                    find(len + 1);
                    visit[i] = false;
                }
            }
        }
        else {
            int sub = Math.abs(arr[len - 1] - arr[len - 2]), prev = arr[len - 1];
            int[] next = {prev + 2 * sub, prev - 2 * sub, prev + sub / 2, prev - sub / 2};
            for (int i = 0; i < 4; i++) {
                if (isIn(next[i]) && !visit[next[i]]) {
                    visit[next[i]] = true;
                    arr[len] = next[i];
                    find(len + 1);
                    visit[next[i]] = false;
                }
            }
        }
    }
    static boolean isIn(int num){
        return 0<num&&num<=n;
    }
}