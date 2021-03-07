package Codeup.Basic100by1060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1020 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String Resident_Registration_number = br.readLine();
			
			StringTokenizer stk = new StringTokenizer(Resident_Registration_number,"-");
			
			while (stk.hasMoreTokens()) {
				System.out.print(stk.nextToken());
			}
												
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
