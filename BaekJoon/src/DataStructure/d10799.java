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
					stack.pop();
					// )를 만났을 때 전 문자가 (이면 레이저, 아니면 파이프가 끝난 것
					// 레이저를 만났을 때 레이저의 위치에서의 쇠파이스 개수를 더하게 되므로, 파이프가 끝나면 별개로 개수를 더해주어야 합니다.
					if(prevch == '(')
						count += stack.size();
					else
						++count; 
					
				}
				prevch = ch;
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

