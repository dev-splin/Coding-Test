package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g1343 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine();
			
			char arr[] = str.toCharArray();
			
			StringTokenizer stk = new StringTokenizer(str, ".");
			
			boolean isPossible = true;
			
			while(stk.hasMoreTokens()) {
				
				int length = stk.nextToken().length();
				
				if(length % 2 != 0) {
					isPossible = false;
					break;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
