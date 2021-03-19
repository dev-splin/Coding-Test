package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class d9095 {
	static int nums[];
	
	public static int dp(int n) {
		if(n < 4 || nums[n] != 0)
			return nums[n];
		
		return dp(n-1) + dp(n-2) + dp(n-3);
	}
	
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			int t = Integer.parseInt(br.readLine().trim());
			
			nums = new int[11];
			nums[1] = 1;
			nums[2] = 2;
			nums[3] = 4;
			
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine().trim());
				
				bw.write(Integer.toString(dp(n)));
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
