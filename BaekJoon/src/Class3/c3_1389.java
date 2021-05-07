package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c3_1389 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			int arr[][] = new int[n+1][n+1];
			
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				
				int num1 = Integer.parseInt(stk.nextToken());
				int num2 = Integer.parseInt(stk.nextToken());
				
				arr[num1][num2] = 1;
				arr[num2][num1] = 1;
			}
			
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if(i != j && arr[i][j] == 0)
						arr[i][j] = 500000;
			
			for (int k = 1; k <= n; k++)
				for (int i = 1; i <= n; i++)
					for (int j = 1; j <= n; j++)
						if(arr[i][j] > arr[i][k] + arr[k][j])
							arr[i][j] = arr[i][k] + arr[k][j];
			
			int min = Integer.MAX_VALUE;
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int j = 1; j <= n; j++) {
					sum += arr[i][j];
				}
				if(min > sum) {
					min = sum;
					ans = i;
				}
			}
			
			System.out.println(ans);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}