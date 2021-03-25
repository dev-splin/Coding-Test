package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class d11052 {
	static int cards[];
	static int memo[];
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int n = Integer.parseInt(br.readLine().trim());

			cards = new int[n+1];
			memo = new int[n+1];
			
			String Prices = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(Prices);
			int count = stk.countTokens();
			
			for (int i = 1; i <= count; i++) 
				cards[i] = Integer.parseInt(stk.nextToken());
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					memo[i] = Math.max(memo[i], memo[i-j] + cards[j]); 
				}
			}
			
			bw.write(Integer.toString(memo[n]));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
