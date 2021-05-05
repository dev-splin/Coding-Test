package Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c2_10250 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				int h = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				int n = Integer.parseInt(stk.nextToken());
				
				int ho = n / h;
				int floor = n % h;
				
				if(floor > 0)
					++ho;
				else if(floor == 0)
					floor = h;
				
				int result = floor * 100 + ho;
				
				System.out.println(result);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

