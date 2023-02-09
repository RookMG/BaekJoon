import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        char[] answer = br.readLine().toCharArray();
        for(int i=1;i<n;i++) {
        	char[] line = br.readLine().toCharArray();
        	for(int j=0;j<answer.length;j++) {
        		if(answer[j]!=line[j]) {
        			answer[j]='?';
        		}
        	}
        }
        System.out.print(String.copyValueOf(answer));
    }
}