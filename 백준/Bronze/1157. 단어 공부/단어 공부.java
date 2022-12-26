import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] record = new int[26];
        char[] now = br.readLine().toCharArray();
        for(int i=0;i<now.length;i++){
            record[Character.toLowerCase(now[i])-'a']++;
        }
        int max = 0;
        char most=' ';
        for(int i=0;i<26;i++){
            if(max==record[i]&&max!=0){
                most = '?';
            }else if(max<record[i]){
                max = record[i];
                most = (char)((int)'A'+i);
            }
        }
        System.out.println(most);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}