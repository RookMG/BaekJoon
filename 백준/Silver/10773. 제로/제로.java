import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num!=0){
                s.add(num);
            }else{
                s.pop();
            }
        }
        int sum = 0;
        while(!s.empty()){
            sum+=s.pop();
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}