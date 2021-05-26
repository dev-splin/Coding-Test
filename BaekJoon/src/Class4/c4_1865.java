package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_1865 {
	static final int INF = 1000000000;
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			int tc= Integer.parseInt(br.readLine());
			
			for (int i = 0; i < tc; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(stk.nextToken());
				int m = Integer.parseInt(stk.nextToken());
				int w = Integer.parseInt(stk.nextToken());
				
				int arr[][] = new int[n+1][n+1];
				
				for (int j = 1; j <= n; j++)
					for (int k = 1; k <= n; k++)
						arr[j][k] = INF;
				
				
				for (int j = 0; j < m; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					
					if(arr[node1][node2] < time)
						continue;
					
					arr[node1][node2] = time;
					arr[node2][node1] = time;
				}
				
				for (int j = 0; j < w; j++) {
					stk = new StringTokenizer(br.readLine());
					
					int node1 = Integer.parseInt(stk.nextToken());
					int node2 = Integer.parseInt(stk.nextToken());
					int time = Integer.parseInt(stk.nextToken());
					arr[node1][node2] = -time;
				}
				
				for (int k = 1; k <= n; k++)
					for (int j = 1; j <= n; j++)
						for (int l = 1; l <= n; l++)
							if(arr[j][l] > arr[j][k] + arr[k][l])
								arr[j][l] = arr[j][k] + arr[k][l];
				
				boolean isPossible = false;
				
				for (int j = 1; j <= n; j++)
					if(arr[j][j] < 0)
						isPossible = true;
				
				if(isPossible)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
