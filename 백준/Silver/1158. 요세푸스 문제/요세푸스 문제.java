import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), position = -1;
        LinkedList<Integer> circle = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            circle.add(i);
        }
        sb.append("<");
        while(n!=0){
            position=(position+k)%n;
            sb.append(circle.get(position));
            circle.remove(position);
            position--;
            if(n!=1)
                sb.append(", ");
            n--;
        }
        sb.append(">");
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}