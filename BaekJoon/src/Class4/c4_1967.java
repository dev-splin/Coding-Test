package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class c4_1967 {
	static List<Node> list[];
	static boolean visit[];
	static int max = 0;
	static int nextIndex = 1;
	
	public static void DFS(int cur, int sum) {
		if(sum > max) {
			nextIndex = cur;
			max = sum;
		}
		
		visit[cur] = true;
		
		for(Node node : list[cur]) {
			if(visit[node.end])
				continue;
			
			DFS(node.end, sum + node.dist);
		}
	}
	
	public static class Node {
		int end;
		int dist;
		
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			list = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < n-1; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(stk.nextToken());
				int node2 = Integer.parseInt(stk.nextToken());
				int dist = Integer.parseInt(stk.nextToken());
				
				list[node1].add(new Node(node2, dist));
				list[node2].add(new Node(node1, dist));
			}
			
			visit = new boolean[n+1];
			int start = 1;
			DFS(start,0);
			
			max = 0;
			start = nextIndex;
			visit = new boolean[n+1];
			DFS(start,0);
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
