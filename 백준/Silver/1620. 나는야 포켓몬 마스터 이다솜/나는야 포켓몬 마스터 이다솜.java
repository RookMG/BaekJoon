import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> nameToNum = new HashMap<>();
        HashMap<Integer,String> numToName = new HashMap<>();
        for(int i=1;i<=n;i++){
            String input = br.readLine();
            nameToNum.put(input,i);
            numToName.put(i,input);
        }
    for(int i=0;i<m;i++){
            String input = br.readLine();
            if(nameToNum.containsKey(input)){
                sb.append(nameToNum.get(input));
            }else{
                sb.append(numToName.get(Integer.parseInt(input)));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}