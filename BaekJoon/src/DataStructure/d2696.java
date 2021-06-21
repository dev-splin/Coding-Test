package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d2696 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < t; i++) {
				int m = Integer.parseInt(br.readLine());
				
				PriorityQueue<Integer> minPq = new PriorityQueue<>();
				PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)->b-a);
				List<Integer> medians = new ArrayList<>();
				
				int count = 0;
				for (int j = 0; j <= m/10; j++) {
					StringTokenizer stk = new StringTokenizer(br.readLine());
					
					while(stk.hasMoreTokens()) {
						++count;
						int num = Integer.parseInt(stk.nextToken());
						
						if(maxPq.isEmpty() || maxPq.peek() >= num)
							maxPq.add(num);
						else if(maxPq.peek() < num)
							minPq.add(num);
						
						if(maxPq.size() - minPq.size() > 1)
							minPq.add(maxPq.poll());
						else if(minPq.size() > maxPq.size())
							maxPq.add(minPq.poll());
						
						if(count % 2 == 1)
							medians.add(maxPq.peek());
					}
				}
				sb.append(medians.size()).append('\n');
				
				for (int j = 0; j < medians.size(); j++) {
					sb.append(medians.get(j));
					
					if(j % 10 == 9 && j != medians.size()-1)
						sb.append('\n');
					else
						sb.append(' ');
				}
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
