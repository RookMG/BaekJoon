import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), answer = 0, max = -1;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            s.push(Integer.parseInt(br.readLine()));
        }
        while(!s.empty()){
            int num = s.pop();
            if(num>max){
                max = num;
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}