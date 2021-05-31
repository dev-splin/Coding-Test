package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_2206 {
	
	public static class Point {
		int row;
		int col;
		int count;
		int distroy;
		
		public Point(int row, int col, int count, int distroy) {
			this.row = row;
			this.col = col;
			this.count = count;
			this.distroy = distroy;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int map[][] = new int[n+1][m+1];
			
			
			for (int i = 1; i <= n; i++) {
				String str = br.readLine();
				
				for (int j = 1; j <= m; j++)
					map[i][j] = str.charAt(j-1) - 48;
			}
			
			int dirRow[] = {-1,1,0,0};
			int dirCol[] = {0,0,-1,1};
			
			int min = Integer.MAX_VALUE;
			
				
			boolean visit[][][] = new boolean[2][n+1][m+1];
			Queue<Point> q = new LinkedList<>();
			
			q.add(new Point(1, 1, 1, 0));
			
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				if(cur.row == n && cur.col == m) {
					min = Math.min(min, cur.count);
					continue;
				}
				
				for (int i = 0; i < 4; i++) {
					int nextRow = cur.row + dirRow[i];
					int nextCol = cur.col + dirCol[i];
					
					if(nextRow >= 1 && nextRow <= n &&
							nextCol >= 1 && nextCol <= m) {
						
						if(cur.distroy == 1) {
							if(!visit[1][nextRow][nextCol] && map[nextRow][nextCol] == 0) {
								visit[1][nextRow][nextCol] = true;
								q.add(new Point(nextRow, nextCol, cur.count+1, 1));
							}
						} else {
							if(map[nextRow][nextCol] == 0 && !visit[0][nextRow][nextCol]) {
								visit[0][nextRow][nextCol] = true;
								q.add(new Point(nextRow, nextCol, cur.count+1, 0));
							} else if(map[nextRow][nextCol] == 1 && !visit[1][nextRow][nextCol]){
								visit[1][nextRow][nextCol] = true;
								q.add(new Point(nextRow, nextCol, cur.count+1, 1));
							}
						}
					}
				}
			}
			
			if(min == Integer.MAX_VALUE)
				min = -1;
			
			System.out.println(min);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
