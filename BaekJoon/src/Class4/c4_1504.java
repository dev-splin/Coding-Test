package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class c4_1504 {
	static int n;
	static final int INF = 1000000000;
	static List<Point> list[];
	
	public static class Point {
		int b;
		int c;
		
		public Point(int b, int c) {
			this.b = b;
			this.c = c;
		}
	}
	
	public static Point djikstra(Point start, int dst) {
		
		int d[] = new int[n+1];
		Arrays.fill(d, INF);
		
		PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->a.c - b.c);
		pq.add(start);
		d[start.b] = start.c;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.c > d[cur.b])
				continue;
			
			for (int i = 0; i < list[cur.b].size(); i++) {
				Point p = list[cur.b].get(i);
				
				int dist = cur.c + p.c;
				
				if(d[p.b] > dist) {
					pq.add(new Point(p.b, dist));
					d[p.b] = dist;
				}
			}
		}
		
		return new Point(dst, d[dst]);
	}
	
	public static int answer(int v1, int v2) {
		Point next = null;
		
		next = djikstra(new Point(1, 0), v1);
		next = djikstra(next, v2);
		next = djikstra(next, n);
		
		return next.c;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			
			list = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < e; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
				
				list[a].add(new Point(b, c));
				list[b].add(new Point(a, c));
			}
			
			stk = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(stk.nextToken());
			int v2 = Integer.parseInt(stk.nextToken());
			
			int ans = Math.min(answer(v1, v2), answer(v2, v1));
			
			if(ans == INF)
				System.out.println(-1);
			else
				System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
