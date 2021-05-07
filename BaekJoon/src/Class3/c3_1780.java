package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_1780 {
	static int minus = 0;
	static int zero = 0;
	static int one = 0;
	static int arr[][];
	
	public static void cutPaper(int row, int col, int size) {
		if(checkPaper(row, col, size)) {
			if(arr[row][col] == -1)
				++minus;
			else if(arr[row][col] == 0)
				++zero;
			else
				++one;
			return;
		}
		
		int nextSize = size / 3;
		
		cutPaper(row, col, nextSize);
		cutPaper(row, col + nextSize, nextSize);
		cutPaper(row, col + nextSize * 2, nextSize);
		
		cutPaper(row + nextSize, col, nextSize);
		cutPaper(row + nextSize, col + nextSize, nextSize);
		cutPaper(row + nextSize, col + nextSize * 2, nextSize);
		
		cutPaper(row + nextSize * 2, col, nextSize);
		cutPaper(row + nextSize * 2, col + nextSize, nextSize);
		cutPaper(row + nextSize * 2, col + nextSize * 2, nextSize);
	}
	
	public static boolean checkPaper(int row, int col, int size) {
		
		int cmp = arr[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++)
				if(cmp != arr[i][j])
					return false;
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
			
			cutPaper(0, 0, n);
			
			System.out.println(minus);
			System.out.println(zero);
			System.out.println(one);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}