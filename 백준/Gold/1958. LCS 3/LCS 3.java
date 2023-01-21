import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray(), arr2 = br.readLine().toCharArray(), arr3 = br.readLine().toCharArray();
        int l1 = arr1.length, l2 = arr2.length, l3 = arr3.length;
        int[][][] lcs = new int[l1+1][l2+1][l3+1];
        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                for(int k=1;k<=l3;k++) {
                    lcs[i][j][k] = (arr1[i-1] == arr2[j-1] && arr1[i-1] == arr3[k-1])?lcs[i - 1][j - 1][k - 1] + 1:Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k],lcs[i][j][k - 1]));
                }
            }
        }
        System.out.println(lcs[l1][l2][l3]);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}