import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        HashSet<String> unheard = new HashSet<>(), unseen = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) unheard.add(br.readLine());
        for(int i=0;i<M;i++){
            String name = br.readLine();
            if(!unheard.contains(name)) continue;
            list.add(name);
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(String name:list) sb.append(name).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}