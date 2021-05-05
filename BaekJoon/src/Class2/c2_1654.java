package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c2_1654 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			
			Integer nums[] = new Integer[k];
			
			for (int i = 0; i < k; i++)
				nums[i] = Integer.parseInt(br.readLine());
			
			Arrays.sort(nums);
			
			long right = nums[k-1];
			long left = 1;
			long mid = 0;
			
			while(left <= right) {
				long count = 0;
				
				mid = (left + right) / 2;
				
				for (int i = 0; i < k; i++)
					count += nums[i] / mid;
				
				if(count < n) {
					right = mid - 1;
				}
				else
					left = mid + 1;
			}
			
			System.out.println(right);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
