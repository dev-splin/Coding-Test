package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class c4_1167 {
	static int v;
	static List<Edge> adjacents[];
	static long maxLength = 0;
	static int maxNum = 0;
	static boolean visit[];
	
	public static class Edge {
		int end;
		int dist;
		
		public Edge(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
	}
	
	public static void DFS(int num, int lengthSum) {
		visit[num] = true;
		
		for(Edge e : adjacents[num]) {
			if(visit[e.end])
				continue;
			
			DFS(e.end, lengthSum + e.dist);
		}
		
		visit[num] = false;
		
		if(maxLength < lengthSum) {
			maxLength = lengthSum;
			maxNum = num;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			v = Integer.parseInt(br.readLine());
			
			adjacents = new ArrayList[v+1];
			visit = new boolean[v+1];
			
			for (int i = 0; i < v; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(stk.nextToken());
				adjacents[num] = new ArrayList<>();
				
				int end = Integer.parseInt(stk.nextToken());
				
				while(end != -1) {
					int dist = Integer.parseInt(stk.nextToken());
					adjacents[num].add(new Edge(end, dist));
					
					end = Integer.parseInt(stk.nextToken());
				}
			}
			
			DFS(1,0);
			maxLength = 0;
			DFS(maxNum,0);
			
			System.out.println(maxLength);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
