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
			
			// 결과를 저장할 배열
			int ans[] = new int[n];
			
			// 뒤에서부터 검사
			for (int i = n-1; i >= 0; --i) {
				// Stack에 검사하는 인덱스의 값보다 작은 값을 가진 인덱스는 뺍니다.
				while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
					stack.pop();
				
				// 검사하는 값보다 작은 값들을 전부 뺐을 때, Stack에 값이 없으면 가장 큰 값이거나, 가장 오른쪽의 값이기 때문에 -1
				if(stack.isEmpty())
					ans[i] = -1;
				// 값이 있다면 검사하는 값보다 큰 값이기 때문에 오큰수 설정
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