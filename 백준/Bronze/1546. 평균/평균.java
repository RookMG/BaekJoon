import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()), total = 0;
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(st.nextToken());
            total+=nums[i];
        }
        Arrays.sort(nums);
        double mean = (total*100)/(double)(nums[n-1]*n);
        System.out.println(mean);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}