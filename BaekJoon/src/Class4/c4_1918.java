package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class c4_1918 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			String str = br.readLine();
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			Map<Character, Integer> priority = new HashMap<>();
			
			// 우선순위 설정 (숫자가 높은 게 우선순위가 높은 것)
			priority.put('(', 0);
			priority.put('+', 1);
			priority.put('-', 1);
			priority.put('*', 2);
			priority.put('/', 2);
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				// 알파벳은 출력
				if(ch >= 'A' && ch <= 'Z')
					sb.append(ch);
				// 여는 괄호는 스택에 추가
				else if(ch == '(')
					stack.push(ch);
				// 닫는 괄호는 여는 괄호가 나올 때까지 출력
				else if(ch == ')') {
					while(!stack.isEmpty()) {
						if(stack.peekFirst() == '(') {
							stack.pop();
							break;
						}
						
						sb.append(stack.pop());
					}
				} else { // +, -, *, / 
					// (스택에서 제일 위에 있는 값의 우선순위) >= (현재 문자의 우선순위) 이어야만 출력
					// +,- 보다 *,/가 먼저 오기 때문에 
					while(!stack.isEmpty() && priority.get(stack.peekFirst()) >= priority.get(ch))
						sb.append(stack.pop());
					stack.push(ch);
				}
			}
			
			// 연산자가 남아 있으면 모두 출력
			while(!stack.isEmpty())
				sb.append(stack.pop());
			
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
