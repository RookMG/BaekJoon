import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public void solution() throws Exception {
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:arr){
            switch(c){
                case '+':
                case '-':
                    while(!stack.isEmpty()){
                        char next = stack.pop();
                        if(next=='('){stack.push(next);break;}
                        if("+-".indexOf(String.valueOf(next))>=0){sb.append(next);break;}
                        sb.append(next);
                    }
                    stack.push(c);
                    break;
                case '*':
                case '/':
                    while(!stack.isEmpty()){
                        char next = stack.pop();
                        if("(+-".indexOf(String.valueOf(next))>=0){stack.push(next);break;}
                        sb.append(next);
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while(!stack.isEmpty()) {
                        char next = stack.pop();
                        if (next=='(') {
                            break;
                        }
                        sb.append(next);
                    }
                    break;
                default:
                    sb.append(c);
            }
        }
        while(!stack.isEmpty()){sb.append(stack.pop());}
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}