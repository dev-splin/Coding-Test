package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sol3 {
	
	public static class Process {
		int id;
		int time;
		int priority;
		
		public Process(int id, int time, int priority) {
			this.id = id;
			this.time = time;
			this.priority = priority;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			PriorityQueue<Process> pq = new PriorityQueue<>((a,b) -> {
				if(a.priority == b.priority)
					return a.id - b.id;
				
				return b.priority - a.priority;
			});
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
				
				pq.add(new Process(a, b, c));
			}
			
			StringBuilder sb = new StringBuilder();
			
			while(!pq.isEmpty() && t > 0) {
				Process cur = pq.poll();
				
				sb.append(cur.id).append('\n');
				
				--cur.time;
				--cur.priority;
				--t;
				
				if(cur.time == 0)
					continue;
				
				pq.add(cur);
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
