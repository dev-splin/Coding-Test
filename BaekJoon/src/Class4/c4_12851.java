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
			
			// ť�� ��ġ, �ð����� �̷���� Point��ü�� �ְ� ť���� �� ��, �湮üũ�� �մϴ�.
			while(!q.isEmpty()) {
				Point cur = q.poll();
				
				// �湮���� �ʾҴٸ� �湮 üũ
				if(!visit.contains(cur.position))
					visit.add(cur.position);
				
				// ������ �Ѿ �ÿ��� ��ŵ
				if(cur.position < 0 || cur.position > 100000)
					continue;
				
				// BFS�̱� ������ ���� �ð��� ã�� �ð����� Ŀ���� ���� ������ �����մϴ�.
				if(cur.time > dstTime)
					break;
				
				// ������ ��ġ(k)�� �������� ã�� �ð��� �����ϰ� count�� �ø��ϴ�.
				if(cur.position == k) {
					dstTime = cur.time;
					++count;
				}
				
				int nextTime = cur.time + 1;
				int next = cur.position + 1;
				
				// �湮���� �ʾ��� �� ť�� �־��ݴϴ�.
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
