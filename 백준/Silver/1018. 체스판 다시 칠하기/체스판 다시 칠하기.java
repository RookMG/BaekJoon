import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken()),m =Integer.parseInt(st.nextToken()), answer = 32;
        String[] board = new String[n];
        for(int i=0;i<n;i++){
            board[i] = br.readLine();
        }
        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                int now = 0;
                for(int x=0;x<8;x++){
                    for(int y=0;y<8;y++){
                        char cell = ((x+y)%2)==0?'B':'W';
                        if(board[i+x].charAt(y+j)==cell){
                            now++;
                        }
                    }
                }
                answer = Math.min(answer,Math.min(now,64-now));
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}