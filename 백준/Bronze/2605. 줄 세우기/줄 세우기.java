import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> ll = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ll.add(i-Integer.parseInt(st.nextToken()),i+1);
        }
        for(int i=0;i<n;i++){
            sb.append(ll.pop()).append(" ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}