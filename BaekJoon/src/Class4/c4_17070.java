package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_17070 {
	static int n;
	static int arr[][];
	// 대각선 방향 체크할 배열 (r,c+1), (r+1,c), (r+1,c+1)
	static int dirRow[] = {0,1,1};
	static int dirCol[] = {1,0,1};
	static int count = 0;
	
	// status가 0 = 가로, 1 = 세로, 2 = 대각선 
	public static void DFS(int status, int row, int col) {
		if(row == n && col == n) {
			++count;
			return;
		}
		
		// 왼쪽 방향으로는 이동하지 않기 때문에 오른쪽 방향의 끝(n)만 체크
		if(status == 0 || status == 2) {
			if(col+1 <= n && arr[row][col+1] != 1)
				DFS(0,row,col+1);
		} 
		
		if(status == 1 || status == 2) {
			if(row+1 <= n && arr[row+1][col] != 1)
				DFS(1,row+1,col);
		}
		
		if(checkDiagonal(row, col))
			DFS(2,row+1,col+1);
	}
	
	// 대각선으로 이동할 수 있는지 체크
	public static boolean checkDiagonal(int row, int col) {
		
		for (int i = 0; i < 3; i++) {
			int nextRow = row+dirRow[i];
			int nextCol = col+dirCol[i];
			if(nextRow > n || nextCol > n || arr[nextRow][nextCol] == 1)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			DFS(0,1,2);
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

