import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) nums[i] = st.nextToken();
        ArrayList<String> nonzero = new ArrayList<>();
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for(int i=0;i<N;i++){
            if(nums[i].charAt(0)=='0') sb.append(nums[i]);
            else nonzero.add(nums[i]);
        }
        if(nonzero.isEmpty()){
            bw.write("INVALID");
            bw.flush();
            return;
        }
        String zeros = sb.toString();
        Collections.sort(nonzero, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+zeros+o2).compareTo(o2+zeros+o1);
            }
        });
        sb.insert(0,nonzero.remove(0));
        Collections.sort(nonzero, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for(String s:nonzero) sb.append(s);
        bw.write(sb.toString());
        bw.flush();
    }
}