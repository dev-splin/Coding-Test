package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c3_1992 {
	public static int arr[][];
	public static String ans = "";
	
	public static void divide(int row, int col, int size) {
		if(check(row, col, size)) {
			if(arr[row][col] == 1)
				ans += '1';
			else
				ans += '0';
			return;
		}
		
		ans += '(';
		int nextSize = size / 2;
		divide(row, col, nextSize);
		divide(row, col + nextSize, nextSize);
		divide(row + nextSize, col, nextSize);
		divide(row + nextSize, col + nextSize, nextSize);
		ans += ')';
	}
	
	public static boolean check(int row, int col, int size) {
		
		int cmp = arr[row][col];
		
		for (int i = row; i < row + size; i++)
			for (int j = col; j < col + size; j++)
				if(arr[i][j] != cmp)
					return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) 
					arr[i][j] = str.charAt(j) - 48;
			}
			
			divide(0, 0, n);
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}