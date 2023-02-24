import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		find(2023,4);
		System.out.println(set.size());
	}
	static void find(int num, int digit){
		if(num>n){return;}
		set.add(num);
		for(int i=0;i<=digit;i++){
			for(int j=0;j<=9;j++){
				int div = (int)Math.pow(10,i), next = (num - num%div)*10 + j*div + num%div;
				if(num!=next) find(next,digit+1);
			}
		}
	}
}