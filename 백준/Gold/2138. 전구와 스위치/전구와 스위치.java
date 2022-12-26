import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    private char[] now0, now1, goal;
    private int n, answer0=0, answer1=1;
    private void flips(int index){
        if(now0[index-1]!=goal[index-1]){
            flip(0,index-1);
            flip(0,index);
            if(index+1<n)
                flip(0,index+1);
            answer0+=1;
        }
        if(now1[index-1]!=goal[index-1]){
            flip(1,index-1);
            flip(1,index);
            if(index+1<n)
                flip(1,index+1);
            answer1+=1;
        }
    }
    private void flip(int num,int index){
        if(num==0){
            now0[index]=(now0[index]=='0')?'1':'0';
        }else{
            now1[index]=(now1[index]=='0')?'1':'0';
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        now0 = br.readLine().toCharArray();
        now1 = now0.clone();
        goal = br.readLine().toCharArray();
        flip(1,0);
        flip(1,1);
        for(int i=1;i<n;i++){
            flips(i);
        }
        if(now0[n-1]==goal[n-1]){
            if(now1[n-1]==goal[n-1])
                sb.append(answer0>answer1?answer1:answer0);
            else
                sb.append(answer0);
        }else{
            if(now1[n-1]==goal[n-1])
                sb.append(answer1);
            else
                sb.append(-1);
        }
        
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}