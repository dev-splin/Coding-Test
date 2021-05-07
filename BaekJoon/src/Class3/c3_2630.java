package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_2630 {
	static int white = 0;
	static int blue = 0;
	
	public static void cutColorPaper(int[][] arr) {
		if(arr.length == 1)
			return;
		
		int tmpLength = arr.length/2;
		int tmpArr[][] = new int[tmpLength][tmpLength];
		
		for (int i = 0; i < 4; i++) {
			int row = (i/2) * tmpLength;
			int col = (i%2) * tmpLength;
			
			for (int j = 0; j < tmpLength; j++) {
				for (int k = 0; k < tmpLength; k++) {
					tmpArr[j][k] = arr[row][col];
					++col;
				}
				col = (i%2) *tmpLength;
				++row;
			}
			
			if(!checkColor(tmpArr))
				cutColorPaper(tmpArr);
		}
	}
	
	public static boolean checkColor(int[][] arr) {
		boolean isPossible = true;
		
		int cmp = arr[0][0];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				if(cmp != arr[i][j]) {
					isPossible = false;
					break;
				}
			if(!isPossible)
				break;
		}
		
		if(isPossible) {
			if(cmp == 1)
				++blue;
			else
				++white;
			return true;
		} else
			return false;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			if(!checkColor(arr))
				cutColorPaper(arr);
			
			System.out.println(white);
			System.out.println(blue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
