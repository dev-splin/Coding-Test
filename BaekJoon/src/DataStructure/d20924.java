package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d20924 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			for (int i = 0; i < n - 1; i++) {
				stk = new StringTokenizer(br.readLine());
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
