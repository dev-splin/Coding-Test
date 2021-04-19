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
				
				// ���ڿ��� '.' �ϳ��� ������ �ݺ����� ����
				if(str.equals("."))
					break;
				
				Stack<Character> stack = new Stack<>();
				
				// ���� ���ڿ��� ������ �̷� �� �ִ��� ������ üũ�� ����
				boolean isPossible = true;
				
				// ���ڿ� ���� ��ŭ �ϳ��� ���ڸ� üũ
				for (int i = 0; i < str.length()-1; i++) {
					char ch = str.charAt(i);
					
					// �����̸� stack�� ����
					if(ch == '(' || ch == '[')
						stack.add(ch);
					// �������� ')'�� ��
					else if(ch == ')') {
						// stack�� ��� ������, �� ¦�� �̷� ������ ������ üũ ������ false�� ����� ���ڿ� üũ ����(2��)
						if(stack.empty()) {
							isPossible = false;
							break;
						}
						// stack�� �����Ͱ� ������ ¦�� �´��� üũ, ¦�� ���� ������ üũ ������ false�� ����� ���ڿ� üũ ����(1��)
						if(stack.peek() == '(')
							stack.pop();
						else {
							isPossible = false;
							break;
						}
					}
					// �������� ']'�� ��, �������� �������� ')'�� ���� ����
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
				
				// ���ڿ��� üũ�� �����µ�, stack�� �����Ͱ� ���� �ִ� ��� (3��)
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

