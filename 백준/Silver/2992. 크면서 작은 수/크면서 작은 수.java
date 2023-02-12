import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static char[] arr;
    public static void main(String[] args) throws Exception{
        arr = br.readLine().toCharArray();
        n = arr.length;
        find(n-2);
        System.out.print(sb);
    }
    static void find(int k) {
        if(k==-1) {
            sb.append(0);
            return;
        }
        if(arr[k]<arr[k+1]) {
            for(int i=0;i<(n-1-k)/2;i++) {
                char tmp = arr[n-1-i];
                arr[n-1-i] = arr[k+1+i];
                arr[k+1+i] = tmp;
            }
            for(int i=k+1;i<n;i++) {
                if(arr[k]<arr[i]) {
                    char tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
            print();
        }else {
            find(k-1);
        }
    }
    static void print() {
        for(int i=0;i<n;i++) {
            sb.append(arr[i]);
        }
    }
}