package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class c4_1865_2 {
	static final int INF = 1000000000;
	static List<Edge> edges;
	
	public static class Edge {
		int start;
		int end;
		int time;
		
		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int tc= Integer.parseInt(br.readLine());
			
			for (int i = 0; i < tc; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				
				edges = new ArrayList<>();
				
				for (int j = 0; j < m; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					
					edges.add(new Edge(node1, node2, time));
					edges.add(new Edge(node2, node1, time));
				}
				
				for (int j = 0; j < w; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					
					edges.add(new Edge(node1, node2, -time));
				}
				
				int d[] = new int[n+1];
				
				Arrays.fill(d, INF);
				
				for (int j = 1; j <= n; j++)
					for(Edge e : edges)
						d[e.end] = Math.min(d[e.end], d[e.start] + e.time);
				
				boolean isPossible = false;
				
				for(Edge e : edges)
					if(d[e.end] > d[e.start] + e.time) {
						isPossible = true;
						break;
					}
				
				if(isPossible)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
