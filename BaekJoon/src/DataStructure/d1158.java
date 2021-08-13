package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class d1158 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			Queue<Integer> curQ = new LinkedList<>();
			Queue<Integer> dstQ = new LinkedList<>();
			Set<Integer> checkNum = new HashSet<>();
			
			for (int i = 1; i <= n; i++) {
				curQ.add(i);
				checkNum.add(i);
			}
			
			int count = 0;
			boolean isFirst = true;
			
			StringBuilder sb = new StringBuilder();
			
			sb.append('<');
			
			Queue<Integer> tmpQ;
			
			if(curQ.size() == 1)
				sb.append(curQ.poll());
			else {
				while(!curQ.isEmpty()) {
					
					int cur = curQ.poll();
					++count;
					
					if(count == k) {
						sb.append(cur);
						count = 0;
						checkNum.remove(cur);
						sb.append(", ");
					} else {
						dstQ.add(cur);
					}
					
					if(curQ.isEmpty()) {
						
						tmpQ = curQ;
						curQ = dstQ;
						dstQ = tmpQ;
					}
					
					if(checkNum.size() == 1)
						break;
					
				}
				
				sb.append(curQ.poll());
			}
			
			sb.append('>');
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
