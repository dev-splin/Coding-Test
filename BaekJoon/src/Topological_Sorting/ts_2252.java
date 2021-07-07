package Topological_Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ts_2252 {
	
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
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				list[a].add(b);
				++edges[b];
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i <= n; i++)
				if(edges[i] == 0)
					q.add(i);
			
			StringBuilder sb = new StringBuilder();
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for (Integer next : list[cur])
					if(--edges[next] == 0)
						q.add(next);
				
				sb.append(cur).append(' ');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
