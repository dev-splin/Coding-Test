package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c4_2638 {
	static int n;
	static int m;
	
	static int arr[][];
	static int tmpArr[][];
	static Queue<Point> cheeses;
	
	static int dirRow[] = {-1,1,0,0};
	static int dirCol[] = {0,0,-1,1};
	
	public static class Point{
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void BFS() {
		
		boolean visit[][] = new boolean[n][m];
		
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(0, 0));
		tmpArr[0][0] = -1;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextRow = cur.row + dirRow[i];
				int nextCol = cur.col + dirCol[i];
				
				if(0 <= nextRow && nextRow < n &&
						0 <= nextCol && nextCol < m && !visit[nextRow][nextCol]) {
					visit[nextRow][nextCol] = true;
					
					if(arr[nextRow][nextCol] == 0) {
						tmpArr[nextRow][nextCol] = -1;
						q.add(new Point(nextRow, nextCol));
					}
				}
			}
		}
	}	
	
	public static boolean meltCheese() {
		
		int size = cheeses.size();
		
		if(size == 0)
			return false;
		
		for (int i = 0; i < size; i++) {
			Point cur = cheeses.poll();
			
			int count = 0;
			
			for (int j = 0; j < 4; j++) {
				int nextRow = cur.row + dirRow[j];
				int nextCol = cur.col + dirCol[j];
				
				if(0 <= nextRow && nextRow < n &&
						0 <= nextCol && nextCol < m && tmpArr[nextRow][nextCol] == -1) {
					++count;
				}
			}
			
			if(count >= 2)
				arr[cur.row][cur.col] = 0;
			else
				cheeses.add(cur);
		}
		
		return true;
	}
	
	public static int solve() {
		int count = 0;
		
		while(true) {
			BFS();
			
			if(meltCheese())
				++count;
			else 
				break;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			arr = new int[n][m];
			tmpArr = new int[n][m];
			cheeses = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
					
					if(arr[i][j] == 1)
						cheeses.add(new Point(i, j));
				}
			}
			
			System.out.println(solve());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
