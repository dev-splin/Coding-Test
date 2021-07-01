package Topological_Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ts_1005 {
	
	public static class Building {
		int num;
		int time;
		
		public Building(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < t; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int k = Integer.parseInt(stk.nextToken());
				
				int times[] = new int[n+1];
				int edges[] = new int[n+1];
				
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					times[j] = Integer.parseInt(stk.nextToken());
				
				List<Integer> list[] = new ArrayList[n+1];
				
				for (int j = 1; j <= n; j++)
					list[j] = new ArrayList<>();
				
				for (int j = 0; j < k; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int x = Integer.parseInt(stk.nextToken());
					int y = Integer.parseInt(stk.nextToken());
					
					list[x].add(y);
					++edges[y];
				}
				
				int dst = Integer.parseInt(br.readLine());
				
				Queue<Integer> q = new LinkedList<>();
				int arrivalTime[] = new int[n+1];
				
				for (int j = 1; j <= n; j++) {
					arrivalTime[j] = times[j];
				
					if(edges[j] == 0) {
						q.add(j);
					}
				}
				
				while(!q.isEmpty()) {
					int curNum = q.poll();
					
					for(Integer num : list[curNum]) {
						arrivalTime[num] = Math.max(arrivalTime[num], arrivalTime[curNum] + times[num]);
						
						if(--edges[num] == 0)
							q.add(num);
					}
				}
				
				sb.append(arrivalTime[dst]).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
