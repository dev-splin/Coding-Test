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
					// )�� ������ �� �� ���ڰ� (�̸� ������, �ƴϸ� �������� ���� ��
					// �������� ������ �� �������� ��ġ������ �����̽� ������ ���ϰ� �ǹǷ�, �������� ������ ������ ������ �����־�� �մϴ�.
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

