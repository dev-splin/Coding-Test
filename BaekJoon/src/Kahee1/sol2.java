package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol2 {
	static int r;
	static int c;
	static int t;
	static int max = 0;
	static char arr[][];
	static int dirRow[] = {-1,1,0,0};
	static int dirCol[] = {0,0,-1,1};
	
	
	public static void solve(int row, int col, int time, int count) {
		if(time >= t)
			return;
		
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dirRow[i];
			int nextCol = col + dirCol[i];
			
			if(!checkRange(nextRow, nextCol))
				continue;
			
			if(arr[nextRow][nextCol] == '#')
				continue;
			
			int nextCount = arr[nextRow][nextCol] == 'S' ? count + 1 : count;
			
			char prev = arr[nextRow][nextCol];
			arr[nextRow][nextCol] = '.';
			
			max = Math.max(max, nextCount);
			solve(nextRow, nextCol, time+1, nextCount);
			
			arr[nextRow][nextCol] = prev;
		}
	}
	
	public static boolean checkRange(int row, int col) {
		if(row > 0 && row <= r && col > 0 && col <= c)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			t = Integer.parseInt(stk.nextToken());
			
			arr = new char[r+1][c+1];
			int startRow = 0;
			int startCol = 0;
			
			for (int i = 1; i <= r; i++) {
				String str = br.readLine();
				
				for (int j = 1; j <= c; j++) {
					char ch = str.charAt(j-1);
					
					arr[i][j] = ch;
					
					if(ch == 'G') {
						startRow = i;
						startCol = j;
					}
				}
			}
			
			solve(startRow, startCol, 0, 0);
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
