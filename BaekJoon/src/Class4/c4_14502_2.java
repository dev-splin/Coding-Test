package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class c4_14502_2 {
	static int n;
	static int m;
	static int map[][];
	static int tmpMap[][];
	static List<Point> virus;
	static int dirRow[] = {-1,1,0,0};
	static int dirCol[] = {0,0,-1,1};
	static int max = 0;
	
	public static class Point {
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
		
	public static void setWall(int start, int depth) {
		if(depth == 3) {
			makeTmpMap();
			
			for(Point p : virus)
				DFS(p.row, p.col);
			
			max = Math.max(max, countEmpty());
			return;
		}
		
		for (int i = start; i < n * m; i++) {
			int row = i / m;
			int col = i % m;
			
			if(map[row][col] == 0) {
				map[row][col] = 1;
				setWall(start + 1, depth + 1);
				map[row][col] = 0;
			}
		}
	}
	
	public static void DFS(int row, int col) {
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dirRow[i];
			int nextCol = col + dirCol[i];
			
			if(0 <= nextRow && nextRow < n &&
					0 <= nextCol && nextCol < m && tmpMap[nextRow][nextCol] == 0) {
				tmpMap[nextRow][nextCol] = 2;
				DFS(nextRow, nextCol);
			}
		}
	}
	
	public static void makeTmpMap() {
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, tmpMap[i], 0, m);
		}
	}
	
	public static int countEmpty() {
		int count = 0;
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if(tmpMap[i][j] == 0)
					++count;
		
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
			tmpMap = new int[n][m];
			virus = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					
					if(map[i][j] == 2) 
						virus.add(new Point(i, j));
				}
			}
			
			setWall(0,0);
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
