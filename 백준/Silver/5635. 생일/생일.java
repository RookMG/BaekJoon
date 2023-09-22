import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Person{
        String name;
        int birth;

        public Person(String name, int birth) {
            this.name = name;
            this.birth = birth;
        }
    }
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Person> pq1 = new PriorityQueue<>(Comparator.comparingInt(o -> -o.birth)), pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o.birth));
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int birth = Integer.parseInt(st.nextToken())+ Integer.parseInt(st.nextToken())*40+ Integer.parseInt(st.nextToken())*1000;
            Person p = new Person(name, birth);
            pq1.add(p);
            pq2.add(p);
        }
        sb.append(pq1.peek().name).append('\n').append(pq2.peek().name);
        bw.write(sb.toString());
        bw.flush();
    }
}