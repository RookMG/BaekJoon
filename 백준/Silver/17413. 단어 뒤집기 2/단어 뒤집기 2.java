import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] line = br.readLine().toCharArray();
        Stack<Character> s = new Stack<>();
        for(int i=0;i<line.length;i++){
            if(line[i]=='<'){
                while(!s.empty()){
                    sb.append(s.pop());
                }
                do{
                    sb.append(line[i++]);
                }while(line[i]!='>');
                sb.append(line[i]);
            }else if(line[i]==' '){
                while(!s.empty()){
                    sb.append(s.pop());
                }
                sb.append(" ");
            }else{
                s.push(line[i]);
            }
        }
        while(!s.empty()){
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}