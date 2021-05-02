package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class d10799 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine();
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			char prevch = 0;
			int count = 0;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch == '(')
					stack.push(ch);
				else if(ch == ')') {
					
					if(prevch == '(')
						count += stack.size()-1;
					else
						++count; 
					
					stack.pop();
				}
				prevch = ch;
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

