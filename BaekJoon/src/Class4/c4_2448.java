package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c4_2448 {
	static int n;
	static char arr[][];
	
	public static void solve(int row, int startCol, int endCol) {
		if(row == 3) {
			int index = n /2;
			arr[0][startCol + 2] = '*';
			arr[1][startCol + 1] = '*';
			arr[1][endCol - 1] = '*';
			
			for (int i = startCol; i <= endCol; i++)
				arr[2][i] = '*';
			
			return;
		}
		
		int diff = (endCol - startCol) / 2;
		int nextStart = startCol + diff/2 + 1;
		int nextEnd = endCol - diff/2 - 1;
		solve(row / 2, nextStart, nextEnd);
		
		for (int i = 0; i < row/2; i++) {
			for (int j = 0; j < diff; j++) {
				arr[row/2+i][startCol+j] = arr[i][j+nextStart];
				arr[row/2+i][startCol+diff+1+j] = arr[i][j+nextStart];
			}
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			n = Integer.parseInt(br.readLine());
		
			int tmp = n;
			int k = 0;
			
			while(tmp != 3) {
				++k;
				tmp /= 2;
			}
			
			int index = 5;
			
			for (int i = 0; i < k; i++)
				index = index * 2 + 1;
			
			arr = new char[index][index];
			
			for (int i = 0; i < index; i++)
				for (int j = 0; j < index; j++)
					arr[i][j] = ' ';
			
			solve(n, 0, index-1);
			
			for (int i = 0; i < index; i++) {
				for (int j = 0; j < index; j++)
					sb.append(arr[i][j]);
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
