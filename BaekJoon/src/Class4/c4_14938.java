package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_14938 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			int areas[][] = new int[n+1][n+1];
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					areas[i][j] = 60000;
			
			int items[] = new int[n+1];
			
			stk = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				items[i] = Integer.parseInt(stk.nextToken());
				areas[i][i] = 0;
			}
			
			for (int i = 0; i < r; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int dist = Integer.parseInt(stk.nextToken());
				
				areas[a][b] = dist;
				areas[b][a] = dist;
			}
			
			for (int k = 1; k <= n; k++)
				for (int i = 1; i <= n; i++)
					for (int j = 1; j <= n; j++)
						areas[i][j] = Math.min(areas[i][j], areas[i][k] + areas[k][j]);
						
			int max = 0;
			for (int i = 1; i <= n; i++) {
				int sum = items[i];
				for (int j = 1; j <= n; j++) {
					if(i == j)
						continue;
					
					if(areas[i][j] <= m)
						sum += items[j];
				}
				max = Math.max(max, sum);
			}
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
