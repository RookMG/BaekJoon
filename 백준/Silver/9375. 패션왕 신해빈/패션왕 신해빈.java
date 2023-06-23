import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> keys = new ArrayList<>();
        String s;
        for(int T = Integer.parseInt(br.readLine());T>0;T--){
            map.clear();
            keys.clear();
            for(int i = Integer.parseInt(br.readLine());i>0;i--){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                s = st.nextToken();
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                    map.put(s,2);
                    keys.add(s);
                }
            }
            int ans = 1;
            for(String k:keys) ans*=map.get(k);
            sb.append(ans-1).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}