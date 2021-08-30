package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class d2504 {
	static ArrayDeque<String> dq = new ArrayDeque<>();
	
	public static boolean run(String srcCh, String dstCh, String notCh, int num) {
		if(dq.isEmpty())
			return false;
		
		if(dq.peekFirst().equals(dstCh)) {
			dq.pop();
			dq.push(Integer.toString(num));
			return true;
		} else {
			int sum = 0;
			
			while(!dq.isEmpty()) {
				String next = dq.peekFirst();
				if(next.equals(notCh))
					return false;
				else if(next.equals(dstCh)) {
					dq.pop();
					sum *= num;
					dq.push(Integer.toString(sum));
					break;
				} else {
					sum += Integer.parseInt(dq.pop());
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			char chars[] = br.readLine().toCharArray();
			
			boolean isPossible = true;
			
			int sum = 0;
			
			for (Character ch : chars) {
				
				if(ch == '(' || ch == '[') {
					dq.push(Character.toString(ch));
				} else if(ch == ')') {
					isPossible = run(")", "(", "[", 2);
						
					if(!isPossible)
						break;
					
				} else if(ch == ']') {
					isPossible = run("]", "[", "(", 3);
					
					if(!isPossible)
						break;
				}
			}
			
			if(!isPossible)
				System.out.println(0);
			else {
				sum = 0;
				while(!dq.isEmpty()) {
					String cur = dq.pop();
					
					if(cur.equals("(") || cur.equals("[")) {
						sum = 0;
						break;
					}
					
					sum += Integer.parseInt(cur);
				}
				
				System.out.println(sum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
