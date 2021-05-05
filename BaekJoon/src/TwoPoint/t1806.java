package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class t1806 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int s = Integer.parseInt(stk.nextToken());
			
			int arr[] = new int[n];
			
			stk = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			int start = 0;
			int end = 0;
			int sum = 0;
			int count = Integer.MAX_VALUE;
			
			while(true) {
				if(s <= sum)
					sum -= arr[start++];
				else if(end == n)
					break;
				else
					sum += arr[end++];
				
				if(sum >= s)
					count = Math.min(count, end - start);
			}
			
			if(count == Integer.MAX_VALUE)
				count = 0;
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
