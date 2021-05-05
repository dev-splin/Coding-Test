package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class c2_1874 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int pushNum = 1;
			Stack<Integer> stack = new Stack<>();
			boolean isPossible = true;
			
			for (int i = 0; i < n; i++) {
				if(!isPossible)
					break;
				
				int num = Integer.parseInt(br.readLine());
				
				while(true) {
					
					if(num >= pushNum) {
						stack.push(pushNum);
						sb.append("+\n");
						++pushNum;
					} else {
						if(stack.empty()) {
							isPossible = false;
							break;
						}
							
						int cmp = stack.pop();
						sb.append("-\n");
						if(cmp == num)
							break;
					}
				}
			}
			
			if(isPossible)
				System.out.println(sb.toString());
			else
				System.out.println("NO");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
