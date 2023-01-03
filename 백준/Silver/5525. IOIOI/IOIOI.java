import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine()), answer = 0;
        char[] s = br.readLine().toCharArray();
        int size = 0;
        for(int i=0;i<m;i++){
            if((s[i]=='I'&&size%2==0)||(s[i]=='O'&&size%2==1)){
                size++;
                if(size>2*n&&size%2==1){
                    answer++;
                }
            }else{
                size = s[i]=='I'?1:0;
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}