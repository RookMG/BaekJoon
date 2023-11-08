import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        Node[] child;
        char value;
        Node fail;
        int isEnd;
        public Node(char value) {
            this.child = new Node[26];
            this.value = value;
            this.isEnd = 0;
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
                if(now.child[c-'a']!=null) {
                    now = now.child[c-'a'];
                }
                else{
                    Node next = new Node(c);
                    now.child[c-'a'] = next;
                    now = next;
                }
            }
            //dict.add(word);
            now.isEnd = Math.max(now.isEnd,word.length());
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
                        while(prev!=root&&prev.child[next.value-'a']==null){
                            prev = prev.fail;
                        }
                        next.fail = prev = prev.child[next.value-'a']==null?prev:prev.child[next.value-'a'];
                    }
                    next.isEnd = Math.max(next.isEnd,prev.isEnd);
                    deque.offerLast(next);
                }
            }
        }

        public void ahoCorasick(String keyword){
            Node now = root;
            for(int i=0;i<keyword.length();i++){
                char c = keyword.charAt(i);
                while(now!=root&&now.child[c-'a']==null) now = now.fail;
                now = now.child[c-'a']==null?now:now.child[c-'a'];
                for(int j=0;j<now.isEnd;j++) found[i-j] = true;
            }
        }
    }
    static final int SIZE = 500;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] found;
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        String target = br.readLine();
        found = new boolean[N];
        int M = Integer.parseInt(br.readLine());
        for(int idx = 0;idx<M;) {
            Trie t = new Trie();
            for (int i=0;i<SIZE&&idx<M;i++,idx++) t.addWord(br.readLine());
            t.getFail();
            t.ahoCorasick(target);
        }
        int ans = 0;
        for(boolean b:found) if(!b) ans++;
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}