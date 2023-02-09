import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        int[][] data = {{1,3,0,3,1},{0,1,0,1,0},{1,1,1,2,1},{1,1,1,1,1},{0,3,1,1,0},{1,2,1,1,1},{1,2,1,3,1},{1,1,0,1,0},{1,3,1,3,1},{1,3,1,1,1}};
        int[] num = data[Integer.parseInt(br.readLine())];
        sb.append(num[0]==1?" * * *\n":"\n");
        switch(num[1]) {
        case 1:sb.append("      *\n      *\n      *\n");break;
        case 2:sb.append("*\n*\n*\n");break;
        case 3:sb.append("*     *\n*     *\n*     *\n");break;
        }
        sb.append(num[2]==1?" * * *\n":"\n");
        switch(num[3]) {
        case 1:sb.append("      *\n      *\n      *");break;
        case 2:sb.append("*\n*\n*");break;
        case 3:sb.append("*     *\n*     *\n*     *");break;
        }
        sb.append(num[4]==1?"\n * * *":"");
        System.out.println(sb);
    }
}