package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_2630_2 {
	static int white = 0;
	static int blue = 0;
	static int arr[][];
	
	public static void partition(int row, int col, int size) {
		if(checkColor(row, col, size)) {
			if(arr[row][col] == 1)
				++blue;
			else
				++white;
			return;
		}
		
		int nextSize = size / 2;
		
		partition(row, col, nextSize);
		partition(row, col + nextSize , nextSize);
		partition(row + nextSize, col, nextSize);
		partition(row + nextSize, col + nextSize, nextSize);
	}
	
	public static boolean checkColor(int row, int col, int size) {
		
		int cmp = arr[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if(arr[i][j] != cmp) {
					return false;
				}
					
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			partition(0, 0, n);
			
			System.out.println(white);
			System.out.println(blue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
