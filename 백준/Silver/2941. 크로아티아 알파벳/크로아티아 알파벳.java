import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        char[] word = br.readLine().toCharArray();
        for(int i=0;i<word.length;i++){
            switch(word[i]){
                case '=':
                if(i>1&&((word[i-1]=='z')&&(word[i-2]=='d'))){sum--;}
                case '-':
                break;
                case 'j':
                if(i>0&&((word[i-1]=='n')||(word[i-1]=='l'))){break;}
                default:
                sum++;
                break;
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}