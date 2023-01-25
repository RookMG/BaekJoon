import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static char[][] codeTable;
	static void initTable() {
		codeTable = new char[8][6];
		codeTable[0]="000000".toCharArray();
		codeTable[1]="001111".toCharArray();
		codeTable[2]="010011".toCharArray();
		codeTable[3]="011100".toCharArray();
		codeTable[4]="100110".toCharArray();
		codeTable[5]="101001".toCharArray();
		codeTable[6]="110101".toCharArray();
		codeTable[7]="111010".toCharArray();
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		initTable();
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		for(int i = 0;i<n;i++) {
			String result = decode(input.substring(i*6, (i+1)*6));
			if("ABCDEFGH".indexOf(result)>=0) {
				sb.append(result);
			}else {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(sb);
	}
	static String decode(String code) {
		char[] arr = code.toCharArray();
		for(int i=0;i<8;i++) {
			int count = 0;
			for(int j=0;j<6;j++) {
				if(arr[j]==codeTable[i][j]) {count++;}
			}
			if(count>=5) {return Character.toString((char)('A'+i));}
		}
		return "0";
	}
}