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
        boolean zero = true;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            zero &= 0==Integer.parseInt(nums[i] = st.nextToken());
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });
        for(String s:nums) sb.append(s);
        bw.write(zero?"0":sb.toString());
        bw.flush();
    }
}