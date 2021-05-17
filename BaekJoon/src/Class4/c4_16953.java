package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class c4_16953 {
	final static int MAX = 1000000000;
	
	public static class Num {
		long num;
		int count;
		
		public Num(long num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			Queue<Num> q = new LinkedList<>();
			Set<Long> visit = new HashSet<>();
			
			Num start = new Num(a, 1);
			visit.add((long)a);
			
			q.add(start);
			
			int ans = -1;
			while(!q.isEmpty()) {
				Num num = q.poll();
				
				if(num.num > MAX)
					continue;
				
				if(num.num == b) {
					ans = num.count;
					break;
				}
				
				long one = num.num * 10 + 1;
				long mul = num.num * 2;
				
				if(!visit.contains(one)) {
					visit.add(one);
					q.add(new Num(one, num.count + 1));
				}
				
				if(!visit.contains(mul)) {
					visit.add(mul);
					q.add(new Num(mul, num.count + 1));
				}
			}
			
			System.out.println(ans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
