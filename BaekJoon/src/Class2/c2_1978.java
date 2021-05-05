package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_1978 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int nums[] = new int[n];

			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int max = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(stk.nextToken());
				if(nums[i] > max)
					max = nums[i];
			}
			
			int primes[] = new int[max+1];
			primes[1] = 1;
			
			for (int i = 2; i <= max; i++) {
				if(primes[i] == 1)
					continue;
				
				for (int j = i + i; j <= max; j+=i)
					primes[j] = 1;
			}
			
			int count = 0;
			for(int num : nums)
				if(primes[num] == 0)
					++count;
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
