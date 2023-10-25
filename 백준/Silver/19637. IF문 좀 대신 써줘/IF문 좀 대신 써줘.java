import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static class Node{
        int val;
        String out;
        Node(String out, int value){
            this.val = value;
            this.out = out;
        }
    }
    static int N, M;
    static Node[] data;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        data = new Node[N = Integer.parseInt(st.nextToken())];
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            data[i] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<M;i++){
            sb.append(lowerBound(Integer.parseInt(br.readLine()))).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static String lowerBound(int target) {
        int l = 0, r = N;
        while(l < r) {
            int m = (l + r) / 2;
            if(data[m].val >= target) r = m;
            else l = m + 1;
        }
        return data[r].out;
    }
}