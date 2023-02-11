import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[] line, key;
    static int[] pi;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        line = br.readLine().toCharArray(); key = br.readLine().toCharArray();
        pi = new int[key.length];
        getPi();
        kmp();
        sb.append(answer.size()).append("\n");
        for(int i:answer){
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
    static void getPi(){
        for(int i=1,j=0;i<pi.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
    static void kmp(){
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j])
                j=pi[j-1];
            if(line[i]==key[j]){
                if(j==key.length-1){
                    answer.add(i-j+1);
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }
    }
}