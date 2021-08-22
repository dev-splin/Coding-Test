package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class d1935 {
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			
			ArrayDeque<Double> stack = new ArrayDeque<>();
			
			int n = Integer.parseInt(br.readLine());
						
			String str = br.readLine();
			
			double nums[] = new double[n];
			
			for (int i = 0; i < n; i++)
				nums[i] = Integer.parseInt(br.readLine()); 
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				if('A' <= ch && ch <= 'Z') {
					stack.push(nums[ch-65]);
					continue;
				}
				
				double b = stack.pop();
				double a = stack.pop();
				
				switch (ch) {
					case '*':
						stack.push(a*b);
						break;
					case '/':
						stack.push(a/b);
						break;
					case '+':
						stack.push(a+b);
						break;
					case '-':
						stack.push(a-b);
						break;
					default:
						break;
				}
			}
			
			System.out.format("%.2f", stack.pop());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

