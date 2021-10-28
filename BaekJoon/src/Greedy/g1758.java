package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class g1758 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
			
			for (int i = 0; i < n; i++)
				pq.add(Integer.parseInt(br.readLine()));			
			
			int seq = 0;
			int sum = 0;
			
			while(!pq.isEmpty()) {
				int curSum = pq.poll() - seq++;
				
				if(curSum > 0)
					sum += curSum;
			}
			
			System.out.println(sum);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
