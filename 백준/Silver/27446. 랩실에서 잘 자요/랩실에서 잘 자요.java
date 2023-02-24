import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), start, answer = 0;
        boolean[] arr = new boolean[n+1];
        Queue<Integer> missing = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr[Integer.parseInt(st.nextToken())]=true;
        }
        for(int i=1;i<=n;i++){
            if(!arr[i]) missing.add(i);
        }
        while(!missing.isEmpty()){
            int now = start = missing.poll();
            while(!missing.isEmpty()&&missing.peek()<=now+3){
                now = missing.poll();
            }
            answer += 7+2*(now-start);
        }
        System.out.print(answer);
    }
}