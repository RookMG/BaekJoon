import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] red = new int[3], green = new int[3], blue = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        red[0] = Integer.parseInt(st.nextToken());
        green[1] = Integer.parseInt(st.nextToken());
        blue[2] = Integer.parseInt(st.nextToken());
        red[1] = red[2] = green[0] = green[2] = blue[0] = blue[1] = 10000000;
        for(int i=1;i<n;i++){
            int[][] tmp = new int[3][3];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                tmp[0][j] = tmp[1][j] = tmp[2][j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<3;j++){
                tmp[0][j] += Math.min(red[(j+1)%3],red[(j+2)%3]);
                tmp[1][j] += Math.min(green[(j+1)%3],green[(j+2)%3]);
                tmp[2][j] += Math.min(blue[(j+1)%3],blue[(j+2)%3]);
            }
            for(int j=0;j<3;j++){
                red[j] = tmp[0][j];
                green[j] = tmp[1][j];
                blue[j] = tmp[2][j];
            }
        }
        System.out.println(Math.min(Math.min(red[1],red[2]),Math.min(Math.min(green[0],green[2]),Math.min(blue[0],blue[1]))));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}