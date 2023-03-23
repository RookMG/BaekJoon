import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{ 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> arr = new ArrayList(set);
        Collections.sort(arr);
        for(int i:arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}