import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder("\n");
    static StringTokenizer st;
    static int[][] parent;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        parent = new int[3][N+1];
        int[] size = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        for(int i=0;i<=N;i++){
            for(int j=0;j<3;j++){
                parent[j][i]=i;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<size[i];j++){
                st = new StringTokenizer(br.readLine());
                int ap = findP(Integer.parseInt(st.nextToken()),i), bp = findP(Integer.parseInt(st.nextToken()),i);
                if(ap!=bp) parent[i][Math.max(ap,bp)] = Math.min(ap,bp);
            }
        }
//        System.out.println(Arrays.deepToString(parent));
        HashMap<Long,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> study = new ArrayList<>();
        for(int i=1;i<=N;i++){
            long key = findP(i,0)*1000000000000L+findP(i,1)*1000000L+findP(i,2);
            if(map.containsKey(key)){
                map.get(key).add(i);
            }else{
                ArrayList<Integer> group = new ArrayList<>();
                group.add(i);
                study.add(group);
                map.put(key,group);
            }
        }
//        System.out.println(study);
        int answer = 0;
        for(ArrayList<Integer> group:study){
            if(group.size()==1) continue;
            answer++;
            for(int i:group){
                sb.append(i).append(' ');
            }
            sb.setLength(sb.length()-1);
            sb.append('\n');
        }
        sb.setLength(sb.length()-1);
        bw.write(Integer.toString(answer));
        bw.write(sb.toString());
        bw.flush();
    }
    static int findP(int a, int idx){
        return parent[idx][a] = (a==parent[idx][a]?a:findP(parent[idx][a],idx));
    }
}