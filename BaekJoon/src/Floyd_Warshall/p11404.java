package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11404 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			
			int bus[][] = new int[n+1][n+1];
			int inf = 20000000;
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
						bus[i][j] = inf;
				}
			}
			
			for (int i = 0; i < m; i++) {
				String nums = br.readLine();
				StringTokenizer stk = new StringTokenizer(nums);
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
				
				if(bus[a][b] > c)
					bus[a][b] = c;
			}
			
			for (int i = 1; i <= n; i++)
				bus[i][i] = 0;
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if(bus[i][j] > bus[i][k] + bus[k][j])
							bus[i][j] = bus[i][k] + bus[k][j];
					}
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(bus[i][j] == inf)
						System.out.print("0 ");
					else
						System.out.print(bus[i][j] + " ");				
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

