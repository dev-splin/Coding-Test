package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class c3_10026 {
	static int n;
	
	public static boolean BFS(int row, int col, boolean[][] visit, char arr[][]) {
		if(visit[row][col])
			return false;
		
		int dirRow[] = {-1,1,0,0};
		int dirCol[] = {0,0,-1,1};
		
		char color = arr[row][col];
		
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		rowQ.add(row);
		colQ.add(col);
		
		visit[row][col] = true;
		
		while(!rowQ.isEmpty()) {
			int curRow = rowQ.poll();
			int curCol = colQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextRow = curRow + dirRow[i];
				int nextCol = curCol + dirCol[i];
				
				if(nextRow >= 0 && nextRow < n &&
						nextCol >= 0 && nextCol < n && !visit[nextRow][nextCol]) {
					
					if(arr[nextRow][nextCol] == color) {
						visit[nextRow][nextCol] = true;
						rowQ.add(nextRow);
						colQ.add(nextCol);
					}
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			char arr[][] = new char[n][n];
			char rgArr[][] = new char[n][n];
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j);
					rgArr[i][j] = s.charAt(j);
					if(s.charAt(j) == 'R' || s.charAt(j) == 'G')
						rgArr[i][j] = 'C';
				}
			}
			
			int nCount = 0;
			int rCount = 0;
			boolean visit[][] = new boolean[n][n];
			boolean rgVisit[][] = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(BFS(i,j,visit, arr))
						++nCount;
					if(BFS(i,j,rgVisit, rgArr))
						++rCount;
				}
			}
			
			System.out.println(nCount + " " + rCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
