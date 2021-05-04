package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d17298_2 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int arr[] = new int[n];
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			
			for (int i = 0; i < n; i++) {
				// Stack에 값이 있을 때, Stack의 맨 위 인덱스의 값이 현재 검사하는 인덱스의 값보다 작으면 빼면서 오큰수 설정
				// 5,4,3, 8(현재 값)같은 경우가 있기 때문에  큰 값이 나오거나 비어있을 때 까지 반복해줍니다.
				while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
					arr[stack.pop()] = arr[i];
				
				// Stack에 값을 쌓습니다.
				stack.push(i);
			}
			
			// 전체를 검사하고 남은 인덱스의 값들을 -1로 설정합니다.
			while(!stack.isEmpty())
				arr[stack.pop()] = -1;
			
			Arrays.stream(arr).forEach(i -> sb.append(i).append(' '));
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
