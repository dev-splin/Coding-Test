package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11403 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			int g[][] = new int[n+1][n+1];
			
			int inf = 100000;
			
			for (int i = 1; i <= n; i++) {
				String adjacents = br.readLine();
				StringTokenizer stk = new StringTokenizer(adjacents);
				
				for (int j = 1; j <= n; j++) {
					g[i][j] = Integer.parseInt(stk.nextToken());
					
					if(g[i][j] == 0)
						g[i][j] = inf;
				}
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if(g[i][j] > g[i][k] + g[k][j])
							g[i][j] = g[i][k] + g[k][j];
					}
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(g[i][j] != inf)
						System.out.print("1 ");
					else
						System.out.print("0 ");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
