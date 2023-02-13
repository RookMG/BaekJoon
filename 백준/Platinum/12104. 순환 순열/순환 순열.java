import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] line, key;
    static int[] pi;
    static int n, answer;
    public static void main(String[] args) throws Exception{
    	char[] a = br.readLine().toCharArray(), b = br.readLine().toCharArray();
    	n = a.length; answer=0;
        line = new boolean[2*n-1]; key = new boolean[n];
        for(int i=0;i<n-1;i++) {
        	line[i] = line[n+i] = (b[i]=='1');
        	key[i] = (a[i]=='1');
        }
        line[n-1] = b[n-1]=='1';
    	key[n-1] = (a[n-1]=='1');
        pi = new int[n];
        getPi();
        kmp();
        System.out.print(answer);
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
                	answer++;
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }
    }
}