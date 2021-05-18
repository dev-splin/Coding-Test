package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_12851 {
	
	public static class Point {
		int position;
		int time;
		
		public Point(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			Set<Integer> visit = new HashSet<>();
			Queue<Point> q = new LinkedList<>();
			
			q.add(new Point(n, 0));
			
			int dstTime = Integer.MAX_VALUE;
			int count = 0;
			
			// 큐에 위치, 시간으로 이루어진 Point객체를 넣고 큐에서 뺄 때, 방문체크를 합니다.
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				// 방문하지 않았다면 방문 체크
				if(!visit.contains(cur.position))
					visit.add(cur.position);
				
				// 범위를 넘어갈 시에는 스킵
				if(cur.position < 0 || cur.position > 100000)
					continue;
				
				// BFS이기 때문에 현재 시간이 찾은 시간보다 커지는 순간 루프를 종료합니다.
				if(cur.time > dstTime)
					break;
				
				// 동생의 위치(k)와 같아지면 찾은 시간을 설정하고 count를 늘립니다.
				if(cur.position == k) {
					dstTime = cur.time;
					++count;
				}
				
				int nextTime = cur.time + 1;
				int next = cur.position + 1;
				
				// 방문하지 않았을 시 큐에 넣어줍니다.
				if(!visit.contains(next))
					q.add(new Point(next, nextTime));
				
				next = cur.position - 1;
				if(!visit.contains(next))
					q.add(new Point(next, nextTime));
				
				next = cur.position * 2;
				if(!visit.contains(next))
					q.add(new Point(next, nextTime));
			}
			
			System.out.println(dstTime);
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
