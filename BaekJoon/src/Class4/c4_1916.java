package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class c4_1916 {
	static int n;
	static List<Node> childs[];
	
	public static class Node {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	public static int djikstra(int start, int end) {
		int d[] = new int[n+1];
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		
		Arrays.fill(d, 1000000000);
		d[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node child : childs[cur.num]) {
				
				if(child.cost > d[child.num])
					continue;
				
				int dist = child.cost + cur.cost;
				
				if(dist < d[child.num]) {
					child.cost = dist;
					pq.add(child);
					d[child.num] = dist;
				}
			}
		}
		
		return d[end];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			childs = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++)
				childs[i] = new ArrayList<>();
			
			StringTokenizer stk = null;
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
				
				childs[a].add(new Node(b, c));
			}
			
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			
			System.out.println(djikstra(start, end));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
