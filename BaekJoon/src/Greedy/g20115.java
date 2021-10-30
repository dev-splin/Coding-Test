package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g20115 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
			
			while(stk.hasMoreTokens())
				pq.add(Integer.parseInt(stk.nextToken()));
			
			double sum = pq.poll();
			
			while(!pq.isEmpty())
				sum += (double)pq.poll() / 2;
			
			System.out.printf("%.1f", sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
