package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d17298 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int arr[] = new int[n];
			
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			
			int ans[] = new int[n];
			
			for (int i = n-1; i >= 0; --i) {
				
				while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
					stack.pop();
				
				if(stack.isEmpty())
					ans[i] = -1;
				else
					ans[i] = arr[stack.peek()];
				stack.push(i);		
			}
			
			Arrays.stream(ans).forEach(i -> sb.append(i).append(' '));
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}