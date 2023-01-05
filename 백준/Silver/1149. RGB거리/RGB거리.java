import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] value = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0;j<3;j++){
            value[j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<n;i++){
            int[] tmp = new int[3];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<3;j++){
                tmp[j] += Math.min(value[(j+1)%3],value[(j+2)%3]);
            }
            value = tmp;
        }
        System.out.println(Math.min(value[0],Math.min(value[1],value[2])));
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}