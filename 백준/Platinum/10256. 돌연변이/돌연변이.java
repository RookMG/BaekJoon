import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        Node[] child;
        char value;
        Node fail;
        boolean isEnd;
        public Node(char value) {
            this.child = new Node[4];
            this.value = value;
            this.isEnd = false;
        }
    }
    static class Trie {
        //ArrayList<String> dict = new ArrayList<>();

        HashSet<String> dup = new HashSet<>();
        Node root = new Node(' ');
        Trie(){
            root.fail = root;
        }
        public void addWord(String word){
            if(dup.contains(word)) return;
            dup.add(word);
            Node now = root;
            for(char c : word.toCharArray()){
                if(now.child[toNum(c)]!=null) {
                    now = now.child[toNum(c)];
                }
                else{
                    Node next = new Node(c);
                    now.child[toNum(c)] = next;
                    now = next;
                }
            }
            //dict.add(word);
            now.isEnd = true;
        }

        public void getFail(){
            ArrayDeque<Node> deque = new ArrayDeque<>();
            deque.add(root);
            while(!deque.isEmpty()){
                Node now = deque.poll();
                for(Node next:now.child){
                    if(next==null) continue;
                    Node prev  = now.fail;
                    if(now==root) next.fail = root;
                    else{
                        while(prev!=root&&prev.child[toNum(next.value)]==null){
                            prev = prev.fail;
                        }
                        next.fail = prev = prev.child[toNum(next.value)]==null?prev:prev.child[toNum(next.value)];
                    }
                    next.isEnd |= prev.isEnd;
                    deque.offerLast(next);
                }
            }
        }

        public int ahoCorasick(String keyword){
            int ret = 0;
            Node now = root;
            for(char c : keyword.toCharArray()){
                while(now!=root&&now.child[toNum(c)]==null) now = now.fail;
                now = now.child[toNum(c)]==null?now:now.child[toNum(c)];
                if(now.isEnd){
                    ret++;
                }
            }
            return ret;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder(), marker = new StringBuilder(), reverse = new StringBuilder(), mutate = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        for(int T = Integer.parseInt(br.readLine());T>0;T--) {
            Trie t = new Trie();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            String target = br.readLine();
            marker.setLength(0);
            marker.append(br.readLine());
            reverse.append(marker);
            reverse.reverse();
            for(int s=0;s<=m;s++){
                for(int e=s;e<=m;e++){
                    mutate.setLength(0);
                    mutate.append(marker);
                    mutate.replace(s,e,reverse.substring(m-e,m-s));
                    t.addWord(mutate.toString());
                }
            }

            t.getFail();
            sb.append(t.ahoCorasick(target)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static int toNum(char ch){
        switch(ch){
            case 'A':return 0;
            case 'T':return 1;
            case 'G':return 2;
            default :return 3;
        }
    }
}