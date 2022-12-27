import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i=1;i<=n;i++){
            ll.offer(i);
        }
        for(int i=0;i<2*n-3;i++){
            int now = ll.pop();
            if(i%2==1){
                ll.offer(now);
            }
        }
        System.out.println(ll.pop());
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}