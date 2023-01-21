import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    static long eval(long a, long b, char action) {
        switch(action) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] line = br.readLine().toCharArray();
        Deque<Long> nums = new LinkedList<>();
        Deque<Character> calcs = new LinkedList<>();
        sb.append(line[0]);
        for(int i=1;i<line.length;i++){
            if("*/+-".indexOf(line[i])>=0) {
                calcs.offer(line[i]);
                nums.offer(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }else {
                sb.append(line[i]);
            }
        }
        nums.offer(Long.parseLong(sb.toString()));
        if(nums.size()>=3) {
            long lnum = nums.pollFirst(), rnum = nums.pollLast();
            while (nums.size() >= 1) {
                char left = calcs.peekFirst(), right = calcs.peekLast();
                boolean calcRight = false;
                if ("*/".indexOf(left) < 0 && "*/".indexOf(right) >= 0) {
                    calcRight = true;
                } else if (!("*/".indexOf(left) >= 0 && "*/".indexOf(right) < 0) && (eval(lnum, nums.peekFirst(), left) < eval(nums.peekLast(), rnum, right))) {
                    calcRight = true;
                }
                if (calcRight) {
                    rnum = eval(nums.pollLast(), rnum, right);
                    calcs.pollLast();
                } else {
                    lnum = eval(lnum, nums.pollFirst(), left);
                    calcs.pollFirst();
                }
            }
            nums.offerFirst(lnum);
            nums.offerLast(rnum);
        }
        System.out.println(nums.size()==2?eval(nums.pollFirst(),nums.pollLast(),calcs.poll()):nums.poll());
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}