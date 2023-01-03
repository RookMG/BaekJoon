import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> unheard = new HashSet<>(), unseen = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            unheard.add(br.readLine());
        }
        for(int i=0;i<m;i++){
            unseen.add(br.readLine());
        }
        for(String name:unheard){
            if(unseen.contains(name)){
                list.add(name);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(String name:list){
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}