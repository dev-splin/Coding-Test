package SlidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class s2075 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++) {
					pq.add(Integer.parseInt(stk.nextToken()));
					
					if(pq.size() > n)
						pq.poll();
				}
			}
						
			System.out.println(pq.poll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
