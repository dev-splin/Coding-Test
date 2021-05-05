package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class c2_9012 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				Stack<Character> stack = new Stack<>();
				
				boolean isPossible = true;
				
				for (int j = 0; j < str.length(); j++) {
					char ch = str.charAt(j);
					if(ch == '(')
						stack.add(ch);
					else {
						try {
							stack.pop();
						} catch (Exception e) {
							isPossible = false;
							break;
						}
					}
				}
				if(stack.size() != 0)
					isPossible = false;
				
				if(isPossible)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

