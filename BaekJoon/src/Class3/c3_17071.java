package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class c3_17071 {
	
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
	
	public static int findBrother(int subin, int brotherPosition) {
		boolean visit[][] = new boolean[500001][2];
		
		Queue<Point> q = new LinkedList<>();
		Point cur = new Point(subin,0);
		q.add(cur);
		
		int time = 0;
		while(true) {
			
			brotherPosition += time;
			
			if(brotherPosition > 500000)
				return -1;
			
			int size = q.size();
			int nextTime = (time + 1) % 2;
			
			for (int i = 0; i < size; i++) {
				cur = q.poll();
				
				if(cur.now == brotherPosition)
					return time;
				
				int nextPosition = cur.now + 1;
				if(nextPosition <= 500000 && !visit[nextPosition][nextTime]) {
					visit[nextPosition][nextTime] = true;
					q.add(new Point(nextPosition,cur.time+1));
				}
				nextPosition = cur.now - 1;
				if(nextPosition >= 0 && !visit[nextPosition][nextTime]) {
					visit[nextPosition][nextTime] = true;
					q.add(new Point(nextPosition,cur.time+1));
				}
				nextPosition = cur.now * 2;
				if(nextPosition <= 500000 && !visit[nextPosition][nextTime]) {
					visit[nextPosition][nextTime] = true;
					q.add(new Point(nextPosition,cur.time+1));
				}
				
			}
			
			if(visit[brotherPosition][time % 2])
				return time;
			
			++time;
			
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int ans = findBrother(n, m);
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
