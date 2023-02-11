import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] line, key;
    static int[] pi;
    static int l;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        key = line = br.readLine().toCharArray();
        getPi();
        for(l=pi[key.length-1];l>0;l--){
            kmp();
            if(answer.size()>2&&answer.get(answer.size()-1)+l==line.length) {
                System.out.println(Arrays.copyOf(key,l));
                return;
            }
        }
        System.out.println(-1);
    }
    static void getPi(){
        pi = new int[key.length];
        for(int i=1,j=0;i<key.length;i++){
            while(j>0&&key[i]!=key[j])
                j = pi[j-1];
            if(key[i]==key[j])
                pi[i] = ++j;
        }
    }
    static void kmp(){
        answer.clear();
        for(int i=0,j=0;i<line.length;i++){
            while(j>0&&line[i]!=key[j])
                j=pi[j-1];
            if(line[i]==key[j]){
                if(j==l-1){
                    answer.add(i-j);
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }
    }
}