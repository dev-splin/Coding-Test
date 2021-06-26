package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_11779 {
	static int n;
	public static List<Edge> adjacents[];
	
	public static class Edge {
		int end;
		int cost;
		
		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			adjacents = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++)
				adjacents[i] = new ArrayList<>();
			
			StringTokenizer stk;
			int start = 0;
			int end = 0;
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				start = Integer.parseInt(stk.nextToken());
				end = Integer.parseInt(stk.nextToken());
				int cost = Integer.parseInt(stk.nextToken());
				
				adjacents[start].add(new Edge(end, cost));
			}
			
			stk = new StringTokenizer(br.readLine());
			start = Integer.parseInt(stk.nextToken());
			end = Integer.parseInt(stk.nextToken());
			
			int route[] = new int[n+1];
			int d[] = new int[n+1];
			Arrays.fill(d, 1000000000);
			d[start] = 0;
			
			
			PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
			pq.add(new Edge(start, 0));
			
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if(cur.cost > d[cur.end])
					continue;
				
				for(Edge next : adjacents[cur.end]) {
					int nextCost = next.cost + cur.cost;
					
					if(nextCost < d[next.end]) {
						pq.add(new Edge(next.end, nextCost));
						d[next.end] = nextCost;
						route[next.end] = cur.end;
					}
				}
			}
			
			List<Integer> reulstList = new ArrayList<>();
			
			int index = end;
			
			while(index != 0) {
				reulstList.add(index);
				index = route[index];
			}
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(d[end]).append('\n');
			sb.append(reulstList.size()).append('\n');
			
			for (int i = reulstList.size()-1; i >= 0; --i)
				sb.append(reulstList.get(i)).append(' ');
			sb.append('\n');
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
