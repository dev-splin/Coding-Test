package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class c2_2164 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i = 1; i <= n; i++)
				queue.add(i);
			
			for (int i = 1; i <= n; i++) {
				if(i == n) {
					System.out.println(queue.poll());
					break;
				}
				
				queue.poll();
				queue.add(queue.poll()); 
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

