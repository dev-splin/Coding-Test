package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class c4_14502 {
	static int n;
	static int m;
	static int map[][];
	static List<Point> emptys;
	static List<Point> virus;
	static int max = 0;
	
	public static class Point {
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
		
	public static void DFS(int start, ArrayDeque<Point> walls) {
		if(walls.size() == 3) {
			max = Math.max(max, BFS(emptys.size()-3, walls));
			return;
		}
		
		for (int i = start; i < emptys.size(); i++) {
			walls.push(emptys.get(i));
			DFS(start + 1, walls);
			walls.pop();
		}
	}
	
	public static int BFS(int count, ArrayDeque<Point> walls) {
		
		boolean visit[][] = new boolean[n][m];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if(map[i][j] != 0)
					visit[i][j] = true;
		
		for(Point p : walls)
			visit[p.row][p.col] = true;
		
		
		int dirRow[] = {-1,1,0,0};
		int dirCol[] = {0,0,-1,1};
		
		Queue<Point> q = new ArrayDeque<>();
		
		for(Point p : virus)
			q.add(p);
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextRow = cur.row + dirRow[i];
				int nextCol = cur.col + dirCol[i];
				
				if(0 <= nextRow && nextRow < n &&
						0 <= nextCol && nextCol < m && !visit[nextRow][nextCol]) {
					--count;
					visit[nextRow][nextCol] = true;
					q.add(new Point(nextRow, nextCol));
				}
			}
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
			
			map = new int[n][m];
			emptys = new ArrayList<>();
			virus = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					
					if(map[i][j] == 0)
						emptys.add(new Point(i, j));
					else if(map[i][j] == 2) 
						virus.add(new Point(i, j));
				}
			}
			
			DFS(0,new ArrayDeque<>());
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
