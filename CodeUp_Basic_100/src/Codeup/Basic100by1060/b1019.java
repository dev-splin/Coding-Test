package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1019 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String date = br.readLine();
			
			StringTokenizer stk = new StringTokenizer(date,".");
			
			int i = 0;
			
			while (stk.hasMoreTokens()) {
				int datetoken = Integer.parseInt(stk.nextToken());
				if (i == 0)
					System.out.printf("%04d",datetoken);
				else
					System.out.printf(".%02d",datetoken);
				++i;
				
			}
												
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
