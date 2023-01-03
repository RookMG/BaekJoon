import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n], score = new int[n];
        for(int i=0;i<n;i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        if(n==1){
            System.out.println(stair[0]);
            return;
        }
        else if(n==2){
            System.out.println(stair[0]+stair[1]);
            return;
        }
        score[0]=stair[0];
        score[1]=stair[0]+stair[1];
        score[2]=Math.max(stair[0]+stair[2],stair[1]+stair[2]);
        for(int i=3;i<n;i++){
            score[i]=Math.max(score[i-2]+stair[i],score[i-3]+stair[i-1]+stair[i]);
        }
        System.out.println(score[n-1]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}