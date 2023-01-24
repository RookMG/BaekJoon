import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public void solution() throws Exception {
        int T = Integer.parseInt(br.readLine());
        test:for(int test = 0;test<T;test++){
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> arr = new LinkedList<>();
            st = new StringTokenizer(br.readLine(),"[],");
            for(int i=0;i<n;i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            boolean reverse = false;
            for(char c:command.toCharArray()){
                if(c=='R'){
                    reverse = reverse?false:true;
                }
                else if(n==0){
                        sb.append("error\n");
                        continue test;
                }else if(reverse){
                    n--;
                    arr.pollLast();
                }else{
                    n--;
                    arr.pollFirst();
                }
            }

            sb.append("[");
            for(int i=0;i<n;i++){
                sb.append(reverse?arr.pollLast():arr.pollFirst()).append(",");
            }
            if(n>0){sb.setLength(sb.length()-1);}
            sb.append("]\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}