package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class c2_10773 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int k = Integer.parseInt(br.readLine());
			
			Stack<Long> stack = new Stack<>();
			
			long sum = 0;
			for (int i = 0; i < k; i++) {
				Long num = Long.parseLong(br.readLine());
				
				if(num == 0)
					sum -= stack.pop();
				else {
					stack.add(num);
					sum += num;
				}
			}
			
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
