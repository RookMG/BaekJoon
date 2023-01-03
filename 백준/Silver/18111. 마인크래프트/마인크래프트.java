import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int min = 500, max = 0, sum = 0, height = 0, answer = 0;
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(num,min);
                max = Math.max(num,max);
                map[i][j]=num;
                sum+=num;
            }
        }
        answer = max*m*n*2;
        for(int i=min;i<=max;i++){
            if(b>=(i*m*n-sum)){
                int time = 0;
                for(int j=0;j<n;j++){
                    for(int k=0;k<m;k++){
                        if(map[j][k]>i){
                            time+=2*(map[j][k]-i);
                        }else{
                            time+=i-map[j][k];
                        }
                    }
                }
                if(answer>=time){
                    height = i;
                    answer = time;
                }
            }
        }
        sb.append(answer).append(" ").append(height);
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}