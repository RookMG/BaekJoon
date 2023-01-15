import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public int time(char ch){
        if(ch<'P'){
            return (ch+1)/3-19;
        }
        else if(ch=='W'){
            return 10;
        }else{
            return ch/4-12;
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        char[] word = br.readLine().toCharArray();
        for(char c:word){
            sum+=time(c);
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}