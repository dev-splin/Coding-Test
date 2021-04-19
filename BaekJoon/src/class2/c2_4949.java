package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class c2_4949 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			while(true) {
				String str = br.readLine();
				
				// 문자열에 '.' 하나만 있으면 반복문을 종료
				if(str.equals("."))
					break;
				
				Stack<Character> stack = new Stack<>();
				
				// 현재 문자열이 균형을 이룰 수 있는지 없는지 체크할 변수
				boolean isPossible = true;
				
				// 문자열 길이 만큼 하나씩 문자를 체크
				for (int i = 0; i < str.length()-1; i++) {
					char ch = str.charAt(i);
					
					// 왼쪽이면 stack에 저장
					if(ch == '(' || ch == '[')
						stack.add(ch);
					// 오른쪽이 ')'일 때
					else if(ch == ')') {
						// stack이 비어 있으면, 즉 짝을 이룰 왼쪽이 없으면 체크 변수를 false로 만들고 문자열 체크 종료(2번)
						if(stack.empty()) {
							isPossible = false;
							break;
						}
						// stack에 데이터가 있으면 짝이 맞는지 체크, 짝이 맞지 않으면 체크 변수를 false로 만들고 문자열 체크 종료(1번)
						if(stack.peek() == '(')
							stack.pop();
						else {
							isPossible = false;
							break;
						}
					}
					// 오른쪽이 ']'일 때, 나머지는 오른쪽이 ')'일 때와 동일
					else if(ch == ']') {
						if(stack.empty()) {
							isPossible = false;
							break;
						}
						
						if(stack.peek() == '[')
							stack.pop();
						else {
							isPossible = false;
							break;
						}
					}
						
				}
				
				// 문자열을 체크가 끝났는데, stack에 데이터가 남아 있는 경우 (3번)
				if(!stack.empty())
					isPossible = false;
				
				if(isPossible)
					sb.append("yes\n");
				else
					sb.append("no\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

