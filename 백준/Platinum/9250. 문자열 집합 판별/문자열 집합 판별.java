import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        Node[] child;
        char value;
        Node fail;
        boolean isEnd;
        public Node(char value) {
            this.child = new Node[26];
            this.value = value;
            this.isEnd = false;
        }
        public void print(int depth){
            for(int i=0;i<depth;i++) System.out.print("!--");
            System.out.println(value+" , "+fail.value);
            for(Node n: child) if(n!=null) n.print(depth+1);
        }
    }

    static class Trie {
        ArrayList<String> dict = new ArrayList<>();
        Node root = new Node(' ');
        Trie(){
            root.fail = root;
        }
        public void addWord(String word){
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
            dict.add(word);
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
                        while(prev!=root&&prev.child[next.value-'a']==null){
                            prev = prev.fail;
                        }
                        next.fail = prev = prev.child[next.value-'a']==null?prev:prev.child[next.value-'a'];
                    }
                    next.isEnd |= prev.isEnd;
                    deque.offerLast(next);
                }
            }
        }

        public boolean ahoCorasick(String keyword){
            Node now = root;
            for(char c : keyword.toCharArray()){
                while(now!=root&&now.child[c-'a']==null) now = now.fail;
                now = now.child[c-'a']==null?now:now.child[c-'a'];
                if(now.isEnd){
                    return true;
                }
            }
            return false;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Trie t = new Trie();

        for(int i= Integer.parseInt(br.readLine());i>0;i--){
            t.addWord(br.readLine());
        }
        t.getFail();
//        t.root.print(0);

        for(int i= Integer.parseInt(br.readLine());i>0;i--){
            sb.append(t.ahoCorasick(br.readLine())?"YES\n":"NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}