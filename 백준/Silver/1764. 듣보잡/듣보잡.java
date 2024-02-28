import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) set.add(br.readLine());
        for(int i=0;i<M;i++){
            String name = br.readLine();
            if(set.contains(name)) ans.add(name);
        }
        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for(String name : ans) sb.append(name).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}