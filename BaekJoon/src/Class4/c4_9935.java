package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class c4_9935 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine();
			String explosion = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
				
				if(stack.size() < explosion.length())
					continue;
				
				boolean isPossible = true;
				
				for (int j = 0; j < explosion.length(); j++) {
					if(stack.get(stack.size() - explosion.length() + j) != explosion.charAt(j)) {
						isPossible = false;
						break;
					}
				}
				
				if(isPossible)
					for (int j = 0; j < explosion.length(); j++)
						stack.pop();
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(char ch : stack)
				sb.append(ch);
			
			if(sb.length() == 0)
				System.out.println("FRULA");
			else
				System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
