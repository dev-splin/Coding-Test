package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d9084 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());
				
				int coins[] = new int[n+1];
				
				String amounts = br.readLine();
				StringTokenizer stk = new StringTokenizer(amounts);
				
				for (int j = 1; j <= n; j++)
					coins[j] = Integer.parseInt(stk.nextToken());
				
				int price = Integer.parseInt(br.readLine());
				int memo[] = new int[price+1];
				memo[0] = 1;
				
				for (int j = 1; j <= n; j++) {
					for (int k = coins[j]; k <= price; k++) {
						memo[k] += memo[k - coins[j]];
					}
				}
				
				System.out.println(memo[price]);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}