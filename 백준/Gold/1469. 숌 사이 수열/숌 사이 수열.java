import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] input, answer;
    static boolean found = false;
    static boolean[] visit, fill;
    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        input = new int[n]; answer = new int[2*n]; visit = new boolean[n]; fill = new boolean[2*n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        find(0);
        System.out.print(found?sb:-1);
    }
    static void find(int k) {
        if(found) return;
        if(k==n){
            print();
            found = true;
            return;
        }
        int pos = 0;
        for(int i=0;i<2*n;i++){
            if(!fill[i]){
                pos = i;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(!visit[i]&&pos+input[i]+1<2*n&&!fill[pos+input[i]+1]){
                visit[i] = true;
                fill[pos+input[i]+1] = true;
                fill[pos] = true;
                answer[pos+input[i]+1] = answer[pos] = input[i];
                find(k+1);
                visit[i] = false;
                fill[pos+input[i]+1] = false;
                fill[pos] = false;
            }
        }
    }
    static void print() {
        for(int i=0;i<2*n;i++) {
            sb.append(answer[i]).append(" ");
        }
    }
}