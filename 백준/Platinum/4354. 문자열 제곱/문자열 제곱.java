import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] line, key;
    static int[] pi;
    static int l;
    static boolean valid;
    static Deque<Integer> answer = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
    	loop: while(true) {
	        key = line = br.readLine().toCharArray();
	        if(key.length==1 && key[0]=='.') {
	        	break;
	        }
	        getPi();
	        for(l=pi[key.length-1];l>0;l--){
	        	if(line.length%l==0) {
		            kmp();
		            if(answer.size()*l==line.length) {
		            	valid = true;
		            	while(!answer.isEmpty()) {
		            		if(answer.poll()%l!=0) {
		            			valid = false;
		            		}
		            	}
		            	if(valid) {
			                System.out.println(line.length/l);
			                continue loop;
		            	}
		            }
	        	}
	        }
	        System.out.println(1);
    	}
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