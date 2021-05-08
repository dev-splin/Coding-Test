package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class c3_1927 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				int cmd = Integer.parseInt(br.readLine());
				
				if(cmd == 0)
					if(pq.isEmpty())
						sb.append("0\n");
					else
						sb.append(pq.poll()).append("\n");
				else
					pq.add(cmd);
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}