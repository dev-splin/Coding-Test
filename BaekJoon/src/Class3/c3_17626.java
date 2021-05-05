package Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c3_17626 {
	static int n;
	static int memo[];
	
	public static int DFS(int num) {
		if(num == 0)
			return 0;
		
		if(memo[num] == 0) {
			int min = num;
			for (int i = (int)Math.sqrt(num); i >= 1; --i) {
				min = Math.min(min, DFS(num - i*i));
			}
			memo[num] = min + 1;
		}
		
		return memo[num];
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			n = Integer.parseInt(br.readLine());
			
			memo = new int[n+1];
			memo[1] = 1;
			
			for (int i = 1; i <= n; i++)
				DFS(i);
			
			System.out.println(memo[n]);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
