import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static long goal;
    public static int[] nums;
    public static boolean div(long d){
        long total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i]/d;
        }
        return total<goal?false:true;
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        goal = Long.parseLong(st.nextToken());
        nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        long left = 1, right = 1+(long)nums[n-1], mid=0;
        while(left<=right){
            mid = (left+right)/2;
            if(div(mid))
                left=mid+1;
            else
                right=mid-1;
        }
        System.out.println(right);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}