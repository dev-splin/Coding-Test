package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class c2_10828 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				switch (stk.nextToken()) {
				case "push":
					stack.add(Integer.parseInt(stk.nextToken()));
					break;
				case "pop":
					if(stack.empty())
						sb.append("-1\n");
					else
						sb.append(stack.pop() + "\n");
					break;
				case "size":
					sb.append(stack.size() + "\n");
					break;
				case "empty":
					if(stack.empty())
						sb.append("1\n");
					else
						sb.append("0\n");
					break;
				case "top":
					if(stack.empty())
						sb.append("-1\n");
					else
						sb.append(stack.peek() + "\n");
					break;
				default:
					break;
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}