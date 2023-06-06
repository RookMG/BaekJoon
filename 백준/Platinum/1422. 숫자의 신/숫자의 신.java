import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        ArrayList<String> nums = new ArrayList<>();
        for(int i=0;i<K;i++) nums.add(br.readLine());
        Collections.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()==o2.length()?(o2+o1).compareTo(o1+o2):o2.length()-o1.length();
            }
        });
        for(int i=K;i<N;i++) nums.add(nums.get(0));
        Collections.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });
        for(String s:nums) sb.append(s);
        bw.write(sb.toString());
        bw.flush();
    }
}