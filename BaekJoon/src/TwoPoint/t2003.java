package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class t2003 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			
			int arr[] = new int[n];
			
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(stk.nextToken());
			
			int start = 0;
			int end = 0;
			int sum = 0;
			int count = 0;
			
			while(true) {
				
				if(sum >= m) 
					sum -= arr[start++];
				else if(end == n)
					break;
				else
					sum += arr[end++];
				
				if(sum == m)
					++count;
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
