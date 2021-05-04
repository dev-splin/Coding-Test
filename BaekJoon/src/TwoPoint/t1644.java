package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class t1644 {
	static int arr[];
	
	public static void eratostenes(int n) {
		if(n <= 1)
			return;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(arr[i] == 0)
				for (int j = i*i; j <= n; j += i)
					arr[j] = 1;
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n+1];
			
			eratostenes(n);
			
			int start = 2;
			int end = 2;
			int sum = 0;
			int count = 0;
			
			while(true) {
				boolean isPossible = false;
				if(sum >= n) {
					if(arr[start] == 0) {
						sum -= start;
						isPossible = true;
					}
					++start;
				}
				else if (end == n+1)
					break;
				else {
					if(arr[end] == 0) {
						sum += end;
						isPossible = true;
					}
					++end;
				}
				
				if(sum == n && isPossible)
					++count;
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
