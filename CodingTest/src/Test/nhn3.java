package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nhn3 {
	static int max = 0;
	static int n;
	static int m;
	static int k;
	static int arr[][];
	
	public static void DFS(int row, int sum, int push) {
		if(push == k) {
			max = Math.max(max, sum);
			return;
		}
		
		if(push > k || row > n)
			return;
		
		
		for (int i = 1; i <= m; i++) {
			DFS(row + 1, sum + arr[row][m-i+1], push + i);
		}
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			k = Integer.parseInt(stk.nextToken());
			
			arr = new int[n+1][m+1];
			
			for (int i = 1; i <= n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				for (int j = 1; j <= m; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken());
			}
			
			DFS(1, 0, 0);
			
			System.out.println(max);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
