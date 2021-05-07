package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_1012 {
	
	public static class Point {
		int n;
		int m;
		
		public Point() {
		}
		
		public Point(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}
	
	public static int BFS(int arr[][], List<Point> points) {
		int rowLength = arr.length;
		int colLength = arr[0].length;
		
		int dirRow[] = {-1,1,0,0};
		int dirCol[] = {0,0,-1,1};
		
		boolean check[][] = new boolean[rowLength][colLength];
		Queue<Point> queue = new LinkedList<>();
		
		int count = 0;
		
		for(Point p : points) {
			int n = p.n;
			int m = p.m;
			
			if(arr[n][m] == 1 && check[n][m] == false) {
				queue.add(p);
				check[n][m] = true;
				
				while(!queue.isEmpty()) {
					Point curP = queue.poll();
					n = curP.n;
					m = curP.m;
					
					for (int i = 0; i < 4; i++) {
						int tmpN = n + dirRow[i];
						int tmpM = m + dirCol[i];
						
						if(tmpN >= 0 && tmpN < rowLength
								&& tmpM >= 0 && tmpM < colLength) {
							if(arr[tmpN][tmpM] == 1 && !check[tmpN][tmpM]) {
								check[tmpN][tmpM] = true;
								Point tmpP = new Point(tmpN, tmpM);
								queue.add(tmpP);
							}
						}
					}
				}
				++count;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				int k = Integer.parseInt(stk.nextToken());
				
				int arr[][] = new int[n][m];
				List<Point> points = new ArrayList<>();
				
				for (int j = 0; j < k; j++) {
					stk = new StringTokenizer(br.readLine());
					Point p = new Point();
					p.n = Integer.parseInt(stk.nextToken());
					p.m = Integer.parseInt(stk.nextToken());
					
					points.add(p);
					arr[p.n][p.m] = 1;
				}
				sb.append(BFS(arr,points)).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
