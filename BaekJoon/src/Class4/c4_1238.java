package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class c4_1238 {
	static int n;
	static List<Edge> list[];
	static int xToAll[];
	
	public static class Edge {
		int end;
		int time;
		
		public Edge(int end, int time) {
			this.end = end;
			this.time = time;
		}
	}
	
	public static int djikstra(int start, int end) {
		
		int d[] = new int[n+1];
		
		for (int i = 1; i <= n; i++)
			d[i] = 10000000;
		
		d[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.time - b.time);
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(cur.time > d[cur.end])
				continue;
			
			for(Edge e : list[cur.end]) {
				int nextTime = e.time + cur.time;
				
				if(nextTime < d[e.end]) {
					pq.add(new Edge(e.end, nextTime));
					d[e.end] = nextTime;
				}
			}
		}
		
		if(end == 0) {
			for (int i = 1; i <= n; i++)
				xToAll[i] = d[i];
			return 0;
		} else
			return d[end];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int x = Integer.parseInt(stk.nextToken());
			
			list = new ArrayList[n+1];
			xToAll = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int t = Integer.parseInt(stk.nextToken());
				
				list[a].add(new Edge(b, t));
			}
			
			djikstra(x, 0);
			
			int max = 0;
			for (int i = 1; i <= n; i++) {
				if(x == i)
					continue;
				max = Math.max(max, djikstra(i, x) + xToAll[i]);
			}
			
			System.out.println(max);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
