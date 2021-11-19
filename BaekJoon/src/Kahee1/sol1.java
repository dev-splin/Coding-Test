package Kahee1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol1 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			
			int rg = Integer.parseInt(stk.nextToken());
			int cg = Integer.parseInt(stk.nextToken());
			int rp = Integer.parseInt(stk.nextToken());
			int cp = Integer.parseInt(stk.nextToken());
			
			boolean isPossible = false;
			
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				
				if(str.contains("P") && str.contains("G"))
					isPossible = true;
			}
			
			System.err.println(isPossible ? 1 : 0);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
