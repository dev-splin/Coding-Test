package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d2346 {
	
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int moveNums[] = new int[n+1];
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				moveNums[i] = Integer.parseInt(stk.nextToken());
				dq.addLast(i);
			}
			
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(dq.pollFirst());
			
			int num = moveNums[1];
			
			while(!dq.isEmpty()) {
				sb.append(' ');
				int next = 0;
				
				if(num > 0) {
					while(num != 1) {
						dq.addLast(dq.pollFirst());
						--num;
					}
					next = dq.pollFirst();
				} else {
					while(num != -1) {
						dq.addFirst(dq.pollLast());
						++num;
					}
					next = dq.pollLast();
				}
				
				sb.append(next);
				num = moveNums[next];
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
