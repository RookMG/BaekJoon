import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] line = br.readLine().toCharArray();
        for(char ch:line){
            sb.append(((int)ch-(int)('A')+1)+" ");
        }
        System.out.println(sb);
    }
}