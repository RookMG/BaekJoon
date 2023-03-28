import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visit;
    static int[] link;
    static ArrayList<Integer> clink, dlink;
    static ArrayList<ArrayList<Integer>> l;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test = 1;test<=T;test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cat = Integer.parseInt(st.nextToken()), dog = Integer.parseInt(st.nextToken()), vote = Integer.parseInt(st.nextToken()), answer = 0;
            clink = new ArrayList<>();
            clink.add(-1);
            dlink = new ArrayList<>();
            dlink.add(-2);
            for(int i=0;i<vote;i++){
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                int fnum = Integer.parseInt(first.substring(1)), lnum = Integer.parseInt(st.nextToken().substring(1));
                if(first.charAt(0)=='C'){
                    clink.add(fnum*1000+lnum);
                }else dlink.add(lnum*1000+fnum);
            }
            l = new ArrayList<>();
            l.add(null);
            for(int i=1;i<clink.size();i++){
                ArrayList<Integer> tmp = new ArrayList<>();
                int cnum = clink.get(i);
                for(int j=1;j<dlink.size();j++){
                    int dnum = dlink.get(j);
                    if(cnum/1000==dnum/1000 || cnum%1000==dnum%1000) tmp.add(j);
                }
                l.add(tmp);
            }
            link = new int[dlink.size()+1];
            for (int i = 1; i < l.size(); i++) {
                visit = new boolean[l.size()+1];
                visit[i] = true;
                if (dfs(i)) answer++;
            }
            bw.write(String.format("%d\n",vote-answer));
//            for(int i=0;i<l.size();i++){
//                System.out.println(l.get(i));
//            }
        }
        bw.flush();
    }
    static boolean dfs(int start){
        for(int work:l.get(start)){
            if(link[work]==0){
                link[work] = start;
                return true;
            }else if(!visit[link[work]]){
                visit[link[work]] = true;
                if(dfs(link[work])){
                    link[work] = start;
                    return true;
                }
            }
        }
        return false;
    }
}