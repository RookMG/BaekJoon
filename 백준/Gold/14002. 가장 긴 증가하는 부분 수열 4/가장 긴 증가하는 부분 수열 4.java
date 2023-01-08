import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>(), find = new ArrayList<>();
        list.add(-1000000001);
        for(int i=0;i<n;i++){
            int num = arr[i] = Integer.parseInt(st.nextToken());
            if(num>list.get(list.size()-1)){
                list.add(num);
                find.add(list.size()-1);
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
                find.add(right);
            }
        }
        int num = list.size()-1;
        sb.append(num).append("\n");
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(find.get(i)==num){
                num--;
                s.push(arr[i]);
            }
        }
        while(!s.isEmpty()){
            sb.append(s.pop()).append(' ');
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}