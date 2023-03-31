import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1000000001);
		for(int i=0;i<n;i++){
			int num = Integer.parseInt(br.readLine());
			if(num>list.get(list.size()-1)){
				list.add(num);
				continue;
			}
			int left = 0, right = list.size()-1;
			while(1+left<right){
				int mid = (left+right)/2;
				if(list.get(mid)>=num){
					right = mid;
				}else{
					left = mid;
				}
			}
			list.set(right,num);
		}
		bw.write(Integer.toString(n+1-list.size()));
		bw.flush();
	}
}