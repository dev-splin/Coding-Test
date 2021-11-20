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
			
			int totalCount = rp * cp;
			
			for (int i = 1; i <= r; i++) {
				String str = br.readLine();
				
				for (int j = 1; j <= c; j++) {
					char ch = str.charAt(j-1);
					
					if(ch == 'P') {
						--totalCount;
					}
				}
			}
			
			if(totalCount == 0)
				System.out.println(0);
			else
				System.out.println(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
