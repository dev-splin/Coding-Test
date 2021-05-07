package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_1697 {
	
	public static class Point {
		int now;
		int time;
		
		public Point() {
		}
		
		public Point(int now, int time) {
			this.now = now;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			boolean visit[] = new boolean[100001];
			
			Queue<Point> q = new LinkedList<>();
			Point cur = new Point(n,0);
			q.add(cur);
			
			int count = 0;
			while(!q.isEmpty()) {
				cur = q.poll();
				
				if(cur.now == m)
					break;
				
				int nextPosition = cur.now + 1;
				if(nextPosition <= 100000 && !visit[nextPosition]) {
					visit[nextPosition] = true;
					q.add(new Point(nextPosition,cur.time+1));
				}
				nextPosition = cur.now - 1;
				if(nextPosition >= 0 && !visit[nextPosition]) {
					visit[nextPosition] = true;
					q.add(new Point(nextPosition,cur.time+1));
				}
				nextPosition = cur.now * 2;
				if(nextPosition <= 100000 && !visit[nextPosition]) {
					visit[nextPosition] = true;
					q.add(new Point(nextPosition,cur.time+1));
				}
			}
			
			System.out.println(cur.time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
