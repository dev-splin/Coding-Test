package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class g11508 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
			
			for (int i = 0; i < n; i++)
				pq.add(Integer.parseInt(br.readLine()));
			
			int sum = 0;
			int count = 0;
			
			while(!pq.isEmpty()) {
				int num = pq.poll();
				
				++count;
				
				if(count == 3)
					count = 0;
				else
					sum += num;
			}
			
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
