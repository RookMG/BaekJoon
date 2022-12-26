import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.isEmpty()?-1+"\n":q.pop()+"\n");
                    break;
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty()?1+"\n":0+"\n");
                    break;
                case "front":
                    sb.append(q.isEmpty()?-1+"\n":q.peek()+"\n");
                    break;
                case "back":
                    sb.append(q.isEmpty()?-1+"\n":q.peekLast()+"\n");
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}