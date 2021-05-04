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
				// Stack�� ���� ���� ��, Stack�� �� �� �ε����� ���� ���� �˻��ϴ� �ε����� ������ ������ ���鼭 ��ū�� ����
				// 5,4,3, 8(���� ��)���� ��찡 �ֱ� ������  ū ���� �����ų� ������� �� ���� �ݺ����ݴϴ�.
				while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
					arr[stack.pop()] = arr[i];
				
				// Stack�� ���� �׽��ϴ�.
				stack.push(i);
			}
			
			// ��ü�� �˻��ϰ� ���� �ε����� ������ -1�� �����մϴ�.
			while(!stack.isEmpty())
				arr[stack.pop()] = -1;
			
			Arrays.stream(arr).forEach(i -> sb.append(i).append(' '));
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
