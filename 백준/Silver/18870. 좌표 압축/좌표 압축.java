import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++) set.add(arr[i]=Integer.parseInt(st.nextToken()));
        ArrayList<Integer> list = new ArrayList<>(set);
        HashMap<Integer,Integer> answer = new HashMap<>();
        int idx = 0;
        for(int i:list) answer.put(i,idx++);
        for(int i=0;i<n;i++){
            bw.write(Integer.toString(answer.get(arr[i])));
            bw.write(" ");
        }
        bw.flush();
    }
}