package Class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c4_10830 {
	static int n;
	static int arr[][];
	
	public static int[][] partition(long size) {
		if(size == 1)
			return arr;
		
		int result[][] = partition(size / 2);
		
		result = calc(result, result);
		
		if(size % 2 == 1)
			result = calc(result, arr);
		
		return result;
	}
	
	public static int[][] calc(int src[][], int dst[][]) {
		
		int result[][] = new int[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++) {
					result[i][j] += (src[i][k] % 1000 * dst[k][j] % 1000) % 1000;
					result[i][j] %= 1000;
				}
		
		return result;
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(stk.nextToken());
			long b = Long.parseLong(stk.nextToken());
			
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(stk.nextToken()) % 1000;
			}
			
			int ans[][] = partition(b);
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					sb.append(ans[i][j]).append(' ');
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
