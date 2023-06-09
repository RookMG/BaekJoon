import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final char[] fdata = {'0','1','2','3','4','5','9','7','8','6'};
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> revs = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            revs.add(flip(st.nextToken().toCharArray()));
        }
        revs.add(Collections.min(revs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()==o2.length()?(o2+o1).compareTo(o1+o2):o2.length()-o1.length();
            }
        }));
        Collections.sort(revs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(String s:revs) sb.append(s);
        bw.write(flip(sb.toString().toCharArray()));
        bw.flush();
    }
    static String flip(char[] num){
        char[] f = new char[num.length];
        for(int i=0;i<num.length;i++) f[i] = fdata[num[num.length-1-i]-'0'];
        return new String(f);
    }
}