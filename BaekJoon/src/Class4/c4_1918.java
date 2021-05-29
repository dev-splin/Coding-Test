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
			
			// �켱���� ���� (���ڰ� ���� �� �켱������ ���� ��)
			priority.put('(', 0);
			priority.put('+', 1);
			priority.put('-', 1);
			priority.put('*', 2);
			priority.put('/', 2);
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				// ���ĺ��� ���
				if(ch >= 'A' && ch <= 'Z')
					sb.append(ch);
				// ���� ��ȣ�� ���ÿ� �߰�
				else if(ch == '(')
					stack.push(ch);
				// �ݴ� ��ȣ�� ���� ��ȣ�� ���� ������ ���
				else if(ch == ')') {
					while(!stack.isEmpty()) {
						if(stack.peekFirst() == '(') {
							stack.pop();
							break;
						}
						
						sb.append(stack.pop());
					}
				} else { // +, -, *, / 
					// (���ÿ��� ���� ���� �ִ� ���� �켱����) >= (���� ������ �켱����) �̾�߸� ���
					// +,- ���� *,/�� ���� ���� ������ 
					while(!stack.isEmpty() && priority.get(stack.peekFirst()) >= priority.get(ch))
						sb.append(stack.pop());
					stack.push(ch);
				}
			}
			
			// �����ڰ� ���� ������ ��� ���
			while(!stack.isEmpty())
				sb.append(stack.pop());
			
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
