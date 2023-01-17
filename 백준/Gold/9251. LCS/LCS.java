import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray(), arr2 = br.readLine().toCharArray();
        int l1 = arr1.length, l2 = arr2.length;
        int[][] lcs = new int[l1][l2];
        lcs[0][0] = arr1[0]==arr2[0]?1:0;
        for(int i=1;i<l2;i++) {
        	lcs[0][i] = arr1[0]==arr2[i]?Math.min(1,lcs[0][i-1]+1):lcs[0][i-1];
        }
        for(int i=1;i<l1;i++) {
        	lcs[i][0] = arr1[i]==arr2[0]?Math.min(1,lcs[i-1][0]+1):lcs[i-1][0];
        }
        for(int i=1;i<l1;i++) {
        	for(int j=1;j<l2;j++) {
        		lcs[i][j] = arr1[i]==arr2[j]?lcs[i-1][j-1]+1:Math.max(lcs[i-1][j],lcs[i][j-1]);
        	}
        }
        int length = lcs[l1-1][l2-1], x = l1-1, y = l2-1;
        System.out.println(length);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}