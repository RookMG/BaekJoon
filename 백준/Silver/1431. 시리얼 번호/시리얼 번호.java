import java.io.*;
import java.util.*;
public class Main {
    static Comparator<String> cmp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length()!=o2.length()) return Integer.compare(o1.length(),o2.length());
            int n1 = 0, n2 = 0;
            for(char ch : o1.toCharArray()){
                if(ch>'9'||ch<'0') continue;
                n1+=ch-'0';
            }
            for(char ch : o2.toCharArray()){
                if(ch>'9'||ch<'0') continue;
                n2+=ch-'0';
            }
            return n1==n2?o1.compareTo(o2):Integer.compare(n1,n2);
        }
    };
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0;i<N;i++) arr[i] = br.readLine();
        Arrays.sort(arr,cmp);
        for(int i=0;i<N;i++) sb.append(arr[i]).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}