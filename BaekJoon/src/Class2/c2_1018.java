package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_1018 {
	static String board[];
	static boolean chess[][];
	
	public static int makeChess(int startN, int startM) {
		
		boolean black = true;
		int min = Integer.MAX_VALUE;
		
		for (int k = 0; k < 2; k++) {
			int changeCount = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if(chess[i][j] == black) {
						if(board[i+startN].charAt(j+startM) == 'W')
							++changeCount;
					} else {
						if(board[i+startN].charAt(j+startM) == 'B')
							++changeCount;
					}
						
				}
			}
			black = false;
			min = Math.min(min, changeCount);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			board = new String[n];
			
			chess = new boolean[8][8];
			
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					if(j % 2 == i % 2)
						chess[i][j] = true;
			
			for (int i = 0; i < n; i++)
				board[i] = br.readLine();
			
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i <= n - 8; i++) 
				for (int j = 0; j <= m - 8; j++) 
					min = Math.min(min, makeChess(i, j));
			
			System.out.println(min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

