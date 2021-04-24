package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d_1753 {
	
	public static class Point implements Comparable<Point>{
		int v;
		int w;
		
		public Point() {
		}
		
		public Point(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		final int INF = 10000000;
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(br.readLine());
			
			List<Point> list[] = new ArrayList[v+1];
			
			for (int i = 0; i < e; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(stk.nextToken());
				if(list[u] == null)
					list[u] = new ArrayList<>();
				
				Point point = new Point();
				point.v = Integer.parseInt(stk.nextToken());
				point.w = Integer.parseInt(stk.nextToken());
				
				list[u].add(point);
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			
			Point point = new Point(k,0);
			pq.add(point);
			
			int d[] = new int[v+1];
			for (int i = 1; i <= v; i++)
				d[i] = INF;
			
			d[k] = 0;
			
			while(!pq.isEmpty()) {
				point = pq.poll();
				
				if(d[point.v] < point.w || list[point.v] == null)
					continue;
				
				for (int i = 0; i < list[point.v].size(); i++) {
					
					Point cmpPoint = list[point.v].get(i);
					
					int dist = point.w + cmpPoint.w;
					
					if(dist < d[cmpPoint.v]) {
						d[cmpPoint.v] = dist;
						cmpPoint.w = dist;
						pq.add(cmpPoint);		
					}
				}
			}
			
			for (int i = 1; i <= v; i++) {
				if(d[i] == INF)
					sb.append("INF\n");
				else
					sb.append(d[i]+"\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
