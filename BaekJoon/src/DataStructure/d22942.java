package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d22942 {
	
	public static class Circle {
		int x;
		int r;
		
		public Circle(int x, int r) {
			this.x = x;
			this.r = r;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Circle> pq = new PriorityQueue<>((a,b)-> {
				if(a.r == b.r)
					return b.x - a.x;
				return b.r - a.r;
			});
			
			StringTokenizer stk;
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				
				Circle circle = new Circle(x, r);
				
				pq.add(circle);
			}
			
			Circle cur = pq.poll();
			boolean isPossible = true;
			
			while(!pq.isEmpty()) {
				Circle next = pq.peek();
				
				if(cur.r + next.r < Math.abs(next.x-cur.x) ||
						Math.abs(next.x-cur.x) < Math.abs(next.r - cur.r)) {
					cur = pq.poll();
				}
				else {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
