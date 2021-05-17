package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_11660 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int memo[][] = new int[n+1][n+1];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				int sum = 0;
				for (int j = 1; j <= n; j++) {
					sum += Integer.parseInt(stk.nextToken());
					memo[i][j] = memo[i-1][j] + sum;
				}
			}
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int x1 = Integer.parseInt(stk.nextToken());
				int y1 = Integer.parseInt(stk.nextToken());
				int x2 = Integer.parseInt(stk.nextToken());
				int y2 = Integer.parseInt(stk.nextToken());
				
				int result = memo[x2][y2] - memo[x1-1][y2] - memo[x2][y1-1] + memo[x1-1][y1-1];
				
				sb.append(result).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
