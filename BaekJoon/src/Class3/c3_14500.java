package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_14500 {
	static int n;
	static int m;
	
	static int map[][];
	static boolean visit[][];
	static int max = 0;
	
	static int dirRow[] = {-1,1,0,0};
	static int dirCol[] = {0,0,-1,1};
	
	static int exRow[][] = {{1,1,1,0}, {0,0,0,1}, {0,1,2,1}, {0,1,2,1}};
	static int exCol[][] = {{0,1,2,1}, {0,1,2,1}, {1,1,1,0}, {0,0,0,1}};
	
	public static void DFS(int row, int col, int sum, int depth) {
		if(depth == 4) {
			max = Math.max(sum, max);
			return;
		} 
		
		for (int i = 0; i < 4; i++) {
			int curRow = row + dirRow[i];
			int curCol = col + dirCol[i];
			
			if(curRow >= 0 && curRow < n &&
					curCol >= 0 && curCol < m && !visit[curRow][curCol]) {
				visit[curRow][curCol] = true;
				DFS(curRow, curCol, sum + map[curRow][curCol], depth + 1);
				visit[curRow][curCol] = false;
			}
		}
	}
	
	public static void exception(int row, int col) {
		
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			
			for (int j = 0; j < 4; j++) {
				int curRow = row + exRow[i][j];
				int curCol = col + exCol[i][j];
				
				if(curRow >= 0 && curRow < n &&
						curCol >= 0 && curCol < m && !visit[curRow][curCol]) {
					sum += map[curRow][curCol];
				}
			}
			max = Math.max(max, sum);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			map = new int[n][m];
			visit = new boolean[n][m];
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++)
					map[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visit[i][j] = true;
					DFS(i,j,map[i][j],1);
					visit[i][j] = false;
					exception(i, j);
				}
			}
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
