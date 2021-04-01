package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d2293 {
	
	
	public static void dp() {
		
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String nums = br.readLine();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			int coins[] = new int[n+1];
			int memo[] = new int[k+1];
			
			for (int i = 1; i <= n; i++)
				coins[i] = Integer.parseInt(br.readLine());
			
			memo[0] = 1;
			
			for (int i = 1; i <= n; i++) {
				for (int j = coins[i]; j <= k; j++) {
					memo[j] += memo[j - coins[i]];
				}
			}
			
			System.out.println(memo[k]);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
