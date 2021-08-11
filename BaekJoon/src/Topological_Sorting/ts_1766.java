package Topological_Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ts_1766 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int edges[] = new int[n+1];
			List<Integer> list[] = new ArrayList[n+1];
			
			for (int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(stk.nextToken());
				int end = Integer.parseInt(stk.nextToken());
				
				list[start].add(end);
				++edges[end];
			}
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for (int i = 1; i <= n; i++)
				if(edges[i] == 0)
					pq.add(i);
			
			StringBuilder sb = new StringBuilder();
			
			while(!pq.isEmpty()) {
				int cur = pq.poll();
				
				sb.append(cur).append(' ');
				
				for(Integer next : list[cur]) {
					
					if(--edges[next] == 0)
						pq.add(next);
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
