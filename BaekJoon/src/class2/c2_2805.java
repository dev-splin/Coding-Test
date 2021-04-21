package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c2_2805 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int trees[] = new int[n];
			
			long max = 0;
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				trees[i] = Integer.parseInt(stk.nextToken());
				max = Math.max(max, trees[i]);
			}
			
			long left = 1;
			long right = max;
			long answer = 0;
			
			while(left <= right) {
				
				long mid = (left + right) / 2;
				long sum = 0;
				
				for(int tree : trees) {
					if(tree > mid)
						sum += (tree - mid);
				}
				
				if(sum == m) {
					answer = mid;
					break;
				}
				else if(sum > m) {
					left = mid + 1;
					answer = Math.max(answer, mid);
				} else {
					right = mid - 1;
				}
			}
			
			System.out.println(answer);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}