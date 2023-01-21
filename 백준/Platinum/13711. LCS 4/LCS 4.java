import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(Integer.parseInt(st.nextToken()), i);
        }
        st = new StringTokenizer(br.readLine());
        list.add(-1);
        for(int i=0;i<n;i++){
            int num = map.get(Integer.parseInt(st.nextToken()));
            if(num>list.get(list.size()-1)){
                list.add(num);
            }
            else{
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
        }
        System.out.println(list.size()-1);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}