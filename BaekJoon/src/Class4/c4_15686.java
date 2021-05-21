package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class c4_15686 {
	static int n;
	static int m;
	static List<Point> homes;
	static List<Point> chickens;
	static ArrayDeque<Integer> chickenIndex;
	
	static int dist[];
	static int min = Integer.MAX_VALUE;
	
	public static void DFS(int start, int depth) {
		if(depth == m) {
			
			int sum = 0;
			for (int i = 0; i < homes.size(); i++) {
				Point home = homes.get(i); 
				int dist = Integer.MAX_VALUE;
				
				for(Integer index : chickenIndex) {
					int row = Math.abs(home.row - chickens.get(index).row);
					int col = Math.abs(home.col - chickens.get(index).col);
					dist = Math.min(dist, row + col);
				}
				
				sum += dist;
			}
			
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			chickenIndex.push(i);
			DFS(i+1, depth+1);
			chickenIndex.pop();
		}
	}
	
	public static class Point {
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			homes = new ArrayList<>();
			chickens = new ArrayList<>(); 
			chickenIndex = new ArrayDeque<>();
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(stk.nextToken());
					
					if(num == 1)
						homes.add(new Point(i, j));
					else if(num == 2)
						chickens.add(new Point(i, j));
				}
			}
			
			DFS(0,0);
			
			System.out.println(min);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
