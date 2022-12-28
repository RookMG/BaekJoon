import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), now = 0, answer = -1;
        ArrayList<Integer> done = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>(), nq = new LinkedList<>();
        q.offer(n);
        while(now!=1){
            while(!q.isEmpty()){
                now = q.pop();
                if(now==1)
                    break;
                if(now%2==0&&!done.contains(now/2)){
                    done.add(now/2);
                    nq.offer(now/2);
                }
                if(now%3==0&&!done.contains(now/3)){
                    done.add(now/3);
                    nq.offer(now/3);
                }
                if(!done.contains(now-1)){
                    done.add(now-1);
                    nq.offer(now-1);
                }
            }
            q = nq;
            nq = new LinkedList<>();
            answer++;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}