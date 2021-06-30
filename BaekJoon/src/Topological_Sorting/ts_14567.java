package Topological_Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ts_14567 {
	
	public static class Node {
		int num;
		int level;
		
		public Node(int num, int level) {
			this.num = num;
			this.level = level;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			List<Integer> list[] = new ArrayList[n+1];
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			
			int edge[] = new int[n+1];
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				list[a].add(b);
				++edge[b];
			}
			
			Queue<Node> q = new LinkedList<>();

			for (int i = 1; i <= n; i++) 
				if(edge[i] == 0)
					q.add(new Node(i, 0));
			
			int ans[] = new int[n+1];
			int prev = 1;
				
			while(!q.isEmpty()) {
				Node next = q.poll();
				
				for(Integer num : list[next.num]) {
					
					if(--edge[num] == 0) {
						ans[num] = next.level + 1;
						q.add(new Node(num, next.level + 1));
					}
				}
			}
		
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; i++)
				sb.append(ans[i]+1).append(' ');
			
			System.out.println(sb.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
