package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c4_2448_2 {
	static char arr[][];
	
	public static void partition(int size, int startRow, int startCol) {
		if(size == 3) {
			arr[startRow][startCol] = '*';
			
			arr[startRow+1][startCol-1] = '*';
			arr[startRow+1][startCol+1] = '*';
			
			arr[startRow+2][startCol-2] = '*';
			arr[startRow+2][startCol-1] = '*';
			arr[startRow+2][startCol] = '*';
			arr[startRow+2][startCol+1] = '*';
			arr[startRow+2][startCol+2] = '*';
			return;
		}
			
		partition(size/2, startRow, startCol);
		partition(size/2, startRow + size/2, startCol - size/2);
		partition(size/2, startRow + size/2, startCol + size/2);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
		
			arr = new char[n][n*2-1];
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n*2-1; j++)
					arr[i][j] = ' ';
			
			partition(n, 0, n-1);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n*2-1; j++)
					sb.append(arr[i][j]);
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
