package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_11659 {
	static long memo[];
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			memo = new long[n+1];
			
			stk = new StringTokenizer(br.readLine());
			
			long sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += Long.parseLong(stk.nextToken());
				memo[i] = sum;
			}
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(stk.nextToken());
				int end = Integer.parseInt(stk.nextToken());
				
				sb.append(memo[end] - memo[start-1]).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

