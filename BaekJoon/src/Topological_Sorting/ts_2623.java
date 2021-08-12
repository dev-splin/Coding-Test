package Topological_Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class ts_2623 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			List<Integer> list[] = new ArrayList[n+1];
			int edges[] = new int[n+1];
			
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(stk.nextToken());
				
				int prev = Integer.parseInt(stk.nextToken());
				
				for (int j = 0; j < num-1; j++) {
					int cur = Integer.parseInt(stk.nextToken());
					
					list[prev].add(cur);
					++edges[cur];
					
					prev = cur;
				}
			}
			
			Queue<Integer> q = new LinkedList<>();
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= n; i++) {
				if(edges[i] == 0)
					q.add(i);
				else
					set.add(i);
			}
			
			StringBuilder sb = new StringBuilder();
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				sb.append(cur).append("\n");
				
				for(Integer next : list[cur]) {
					
					if(--edges[next] == 0) {
						q.add(next);
						set.remove(next);
					}
				}
			}
			
			if(set.isEmpty())
				System.out.println(sb.toString());
			else
				System.out.println(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
